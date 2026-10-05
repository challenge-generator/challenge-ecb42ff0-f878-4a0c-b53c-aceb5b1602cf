package com.gestionpedidos.application.service;

import com.gestionpedidos.domain.model.Producto;
import com.gestionpedidos.domain.repository.ProductoRepository;
import com.gestionpedidos.domain.exception.ProductoNoEncontradoException;
import com.gestionpedidos.domain.exception.StockInsuficienteException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto crearProducto(String nombre, String descripcion, BigDecimal precio, int stock) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (precio == null || precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        Producto producto = new Producto();
        producto.setId(UUID.randomUUID());
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);

        return productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public Producto obtenerProductoPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del producto no puede ser nulo");
        }
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Producto> listarTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Producto> buscarProductosPorNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return List.of();
        }
        return productoRepository.findByNombreContaining(nombre);
    }

    public Producto actualizarProducto(UUID id, String nombre, String descripcion, BigDecimal precio, Integer stock) {
        Producto productoExistente = obtenerProductoPorId(id);

        if (nombre != null && !nombre.isBlank()) {
            productoExistente.setNombre(nombre);
        }
        if (descripcion != null) {
            productoExistente.setDescripcion(descripcion);
        }
        if (precio != null && precio.compareTo(BigDecimal.ZERO) > 0) {
            productoExistente.setPrecio(precio);
        }
        if (stock != null && stock >= 0) {
            productoExistente.setStock(stock);
        }

        return productoRepository.save(productoExistente);
    }

    public void eliminarProducto(UUID id) {
        Producto producto = obtenerProductoPorId(id);
        productoRepository.deleteById(producto.getId());
    }

    public void reducirStock(UUID id, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a reducir debe ser mayor que cero");
        }
        Producto producto = obtenerProductoPorId(id);
        producto.reducirStock(cantidad);
        productoRepository.save(producto);
    }

    public void aumentarStock(UUID id, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a aumentar debe ser mayor que cero");
        }
        Producto producto = obtenerProductoPorId(id);
        producto.aumentarStock(cantidad);
        productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public boolean verificarDisponibilidad(UUID productoId, int cantidadRequerida) {
        Producto producto = obtenerProductoPorId(productoId);
        return producto.getStock() >= cantidadRequerida;
    }

    public void validarStockSuficiente(UUID productoId, int cantidadRequerida) {
        if (!verificarDisponibilidad(productoId, cantidadRequerida)) {
            Producto producto = obtenerProductoPorId(productoId);
            throw new StockInsuficienteException(
                String.format("Stock insuficiente para el producto '%s'. Disponible: %d, requerido: %d",
                    producto.getNombre(), producto.getStock(), cantidadRequerida)
            );
        }
    }
}