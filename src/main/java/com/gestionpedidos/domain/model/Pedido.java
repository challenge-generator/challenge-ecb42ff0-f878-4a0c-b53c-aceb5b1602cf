package com.gestionpedidos.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Pedido {
    private UUID id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private String estado;
    private BigDecimal total;
    private List<ProductoPedido> productos;
    
    public Pedido() {
        this.id = UUID.randomUUID();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = "PENDIENTE";
        this.total = BigDecimal.ZERO;
    }
    
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        
        ProductoPedido productoPedido = new ProductoPedido(producto, cantidad);
        this.productos.add(productoPedido);
        this.total = this.total.add(producto.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
    }
    
    public void actualizarEstado(String nuevoEstado) {
        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
        }
        this.estado = nuevoEstado;
        this.fechaActualizacion = LocalDateTime.now();
    }
    
    public static class ProductoPedido {
        private Producto producto;
        private int cantidad;
        
        public ProductoPedido(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }
        
        public Producto getProducto() {
            return producto;
        }
        
        public int getCantidad() {
            return cantidad;
        }
    }
}