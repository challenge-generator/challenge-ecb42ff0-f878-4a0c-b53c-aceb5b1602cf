package com.gestionpedidos.interfaces.rest;

import com.gestionpedidos.application.service.ProductoService;
import com.gestionpedidos.domain.exception.ProductoNoEncontradoException;
import com.gestionpedidos.domain.exception.StockInsuficienteException;
import com.gestionpedidos.domain.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarTodos() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable UUID id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarPorNombre(@RequestParam String nombre) {
        List<Producto> productos = productoService.buscarPorNombre(nombre);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/stock-bajo")
    public ResponseEntity<List<Producto>> productosConStockBajo(@RequestParam(defaultValue = "10") int umbral) {
        List<Producto> productos = productoService.obtenerProductosConStockBajo(umbral);
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoRequest request) {
        Producto producto = productoService.crearProducto(
                request.nombre(),
                request.descripcion(),
                request.precio(),
                request.stockInicial()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable UUID id,
            @RequestBody ProductoRequest request) {
        try {
            Producto producto = productoService.actualizarProducto(
                    id,
                    request.nombre(),
                    request.descripcion(),
                    request.precio()
            );
            return ResponseEntity.ok(producto);
        } catch (ProductoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Producto> actualizarStock(
            @PathVariable UUID id,
            @RequestBody ActualizarStockRequest request) {
        try {
            Producto producto = productoService.actualizarStock(id, request.cantidad());
            return ResponseEntity.ok(producto);
        } catch (ProductoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable UUID id) {
        try {
            productoService.eliminarProducto(id);
            return ResponseEntity.noContent().build();
        } catch (ProductoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/reducir-stock")
    public ResponseEntity<Producto> reducirStock(
            @PathVariable UUID id,
            @RequestBody ReducirStockRequest request) {
        try {
            Producto producto = productoService.reducirStock(id, request.cantidad());
            return ResponseEntity.ok(producto);
        } catch (ProductoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        } catch (StockInsuficienteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public record ProductoRequest(
            String nombre,
            String descripcion,
            BigDecimal precio,
            int stockInicial
    ) {}

    public record ActualizarStockRequest(int cantidad) {}
    public record ReducirStockRequest(int cantidad) {}
}