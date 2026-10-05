package com.gestionpedidos.application.service;

import com.gestionpedidos.domain.exception.PedidoNoEncontradoException;
import com.gestionpedidos.domain.exception.ProductoNoEncontradoException;
import com.gestionpedidos.domain.exception.StockInsuficienteException;
import com.gestionpedidos.domain.model.Pedido;
import com.gestionpedidos.domain.model.Producto;
import com.gestionpedidos.domain.repository.PedidoRepository;
import com.gestionpedidos.domain.repository.ProductoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final PedidoFactory pedidoFactory;
    private final Map<String, PedidoState> estadosPedido;

    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
        this.pedidoFactory = new PedidoFactory();
        this.estadosPedido = inicializarEstados();
    }

    private Map<String, PedidoState> inicializarEstados() {
        Map<String, PedidoState> estados = new ConcurrentHashMap<>();
        estados.put("PENDIENTE", new PedidoState("PENDIENTE", true, false));
        estados.put("CONFIRMADO", new PedidoState("CONFIRMADO", true, false));
        estados.put("EN_PREPARACION", new PedidoState("EN_PREPARACION", true, false));
        estados.put("ENVIADO", new PedidoState("ENVIADO", true, false));
        estados.put("ENTREGADO", new PedidoState("ENTREGADO", false, true));
        estados.put("CANCELADO", new PedidoState("CANCELADO", false, true));
        return estados;
    }

    public Pedido crearPedido(List<ProductoCantidad> productos, UUID clienteId) {
        validarProductos(productos);
        
        Pedido pedido = pedidoFactory.crearPedido(clienteId);
        
        for (ProductoCantidad pc : productos) {
            Producto producto = productoRepository.findById(pc.productoId())
                    .orElseThrow(() -> new ProductoNoEncontradoException(
                            "Producto no encontrado: " + pc.productoId()));
            
            if (producto.getStock() < pc.cantidad()) {
                throw new StockInsuficienteException(
                        "Stock insuficiente para producto: " + producto.getNombre() +
                        ". Stock actual: " + producto.getStock() +
                        ", solicitado: " + pc.cantidad());
            }
            
            producto.reducirStock(pc.cantidad());
            productoRepository.save(producto);
            pedido.agregarProducto(producto, pc.cantidad());
        }
        
        return pedidoRepository.save(pedido);
    }

    private void validarProductos(List<ProductoCantidad> productos) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("La lista de productos no puede estar vacía");
        }
        for (ProductoCantidad pc : productos) {
            if (pc.productoId() == null) {
                throw new IllegalArgumentException("El ID del producto no puede ser nulo");
            }
            if (pc.cantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
            }
        }
    }

    public Optional<Pedido> buscarPorId(UUID id) {
        if (id == null) {
            return Optional.empty();
        }
        return pedidoRepository.findById(id);
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> buscarPorEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
        }
        return pedidoRepository.findByEstado(estado.toUpperCase());
    }

    public Pedido actualizarEstado(UUID id, String nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNoEncontradoException("Pedido no encontrado: " + id));
        
        String estadoUpper = nuevoEstado.toUpperCase();
        PedidoState estado = estadosPedido.get(estadoUpper);
        
        if (estado == null) {
            throw new IllegalArgumentException("Estado de pedido inválido: " + nuevoEstado);
        }
        
        String estadoActual = pedido.getEstado();
        PedidoState estadoActualObj = estadosPedido.get(estadoActual);
        
        if (!estadoActualObj.puedeTransicionar()) {
            throw new IllegalStateException(
                    "No se puede cambiar el estado de un pedido " + estadoActual);
        }
        
        if (estado.esFinal() && !esTransicionValida(estadoActual, estadoUpper)) {
            throw new IllegalStateException(
                    "Transición inválida de " + estadoActual + " a " + estadoUpper);
        }
        
        pedido.actualizarEstado(estadoUpper);
        return pedidoRepository.save(pedido);
    }

    private boolean esTransicionValida(String desde, String hacia) {
        if ("CANCELADO".equals(desde)) {
            return false;
        }
        if ("ENTREGADO".equals(desde)) {
            return false;
        }
        return true;
    }

    public Pedido agregarProducto(UUID pedidoId, UUID productoId, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNoEncontradoException("Pedido no encontrado: " + pedidoId));
        
        if ("CANCELADO".equals(pedido.getEstado()) || "ENTREGADO".equals(pedido.getEstado())) {
            throw new IllegalStateException(
                    "No se pueden agregar productos a un pedido en estado: " + pedido.getEstado());
        }
        
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado: " + productoId));
        
        if (producto.getStock() < cantidad) {
            throw new StockInsuficienteException(
                    "Stock insuficiente. Disponible: " + producto.getStock() + ", solicitado: " + cantidad);
        }
        
        producto.reducirStock(cantidad);
        productoRepository.save(producto);
        pedido.agregarProducto(producto, cantidad);
        
        return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(UUID id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNoEncontradoException("Pedido no encontrado: " + id));
        
        if ("ENVIADO".equals(pedido.getEstado()) || "ENTREGADO".equals(pedido.getEstado())) {
            throw new IllegalStateException(
                    "No se puede eliminar un pedido en estado: " + pedido.getEstado());
        }
        
        restaurarStockProductos(pedido);
        pedidoRepository.deleteById(id);
    }

    private void restaurarStockProductos(Pedido pedido) {
        pedido.getProductos().forEach(pp -> {
            productoRepository.findById(pp.getProducto().getId()).ifPresent(producto -> {
                producto.aumentarStock(pp.getCantidad());
                productoRepository.save(producto);
            });
        });
    }

    public BigDecimal calcularTotal(UUID pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNoEncontradoException("Pedido no encontrado: " + pedidoId));
        return pedido.getTotal();
    }

    public record ProductoCantidad(UUID productoId, int cantidad) {}

    private static class PedidoState {
        private final String nombre;
        private final boolean puedeTransicionar;
        private final boolean esFinal;

        public PedidoState(String nombre, boolean puedeTransicionar, boolean esFinal) {
            this.nombre = nombre;
            this.puedeTransicionar = puedeTransicionar;
            this.esFinal = esFinal;
        }

        public boolean puedeTransicionar() {
            return puedeTransicionar;
        }

        public boolean esFinal() {
            return esFinal;
        }
    }

    private static class PedidoFactory {
        public Pedido crearPedido(UUID clienteId) {
            Pedido pedido = new Pedido();
            return pedido;
        }
    }
}