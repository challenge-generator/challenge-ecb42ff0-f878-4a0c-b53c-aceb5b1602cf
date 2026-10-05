package com.gestionpedidos.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Producto {
    private UUID id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;
    
    public Producto() {
        this.id = UUID.randomUUID();
    }
    
    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        if (this.stock < cantidad) {
            throw new IllegalStateException("Stock insuficiente");
        }
        this.stock -= cantidad;
    }
    
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        this.stock += cantidad;
    }
}