package com.gestionpedidos.interfaces.rest;

import com.gestionpedidos.application.service.PedidoService;
import com.gestionpedidos.domain.exception.PedidoNoEncontradoException;
import com.gestionpedidos.domain.model.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable UUID id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pedido>> buscarPorEstado(@PathVariable String estado) {
        List<Pedido> pedidos = pedidoService.buscarPorEstado(estado);
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody CrearPedidoRequest request) {
        Pedido pedido = pedidoService.crearPedido(request.productos(), request.clienteId());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Pedido> actualizarEstado(
            @PathVariable UUID id,
            @RequestBody ActualizarEstadoRequest request) {
        try {
            Pedido pedido = pedidoService.actualizarEstado(id, request.nuevoEstado());
            return ResponseEntity.ok(pedido);
        } catch (PedidoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/agregar-producto")
    public ResponseEntity<Pedido> agregarProducto(
            @PathVariable UUID id,
            @RequestBody AgregarProductoRequest request) {
        try {
            Pedido pedido = pedidoService.agregarProducto(id, request.productoId(), request.cantidad());
            return ResponseEntity.ok(pedido);
        } catch (PedidoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable UUID id) {
        try {
            pedidoService.eliminarPedido(id);
            return ResponseEntity.noContent().build();
        } catch (PedidoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<BigDecimal> obtenerTotal(@PathVariable UUID id) {
        return pedidoService.buscarPorId(id)
                .map(pedido -> ResponseEntity.ok(pedido.getTotal()))
                .orElse(ResponseEntity.notFound().build());
    }

    public record CrearPedidoRequest(List<ProductoCantidad> productos, UUID clienteId) {}
    public record ProductoCantidad(UUID productoId, int cantidad) {}
    public record ActualizarEstadoRequest(String nuevoEstado) {}
    public record AgregarProductoRequest(UUID productoId, int cantidad) {}
}