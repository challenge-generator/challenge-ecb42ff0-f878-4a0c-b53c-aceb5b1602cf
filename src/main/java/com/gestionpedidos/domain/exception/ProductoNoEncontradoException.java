package com.gestionpedidos.domain.exception;

import java.util.UUID;

public class ProductoNoEncontradoException extends RuntimeException {

    private final UUID productoId;

    public ProductoNoEncontradoException(UUID productoId) {
        super(String.format("No se encontró el producto con ID: %s", productoId));
        this.productoId = productoId;
    }

    public ProductoNoEncontradoException(UUID productoId, String mensajePersonalizado) {
        super(mensajePersonalizado);
        this.productoId = productoId;
    }

    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
        this.productoId = null;
    }

    public ProductoNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.productoId = null;
    }

    public ProductoNoEncontradoException(UUID productoId, Throwable causa) {
        super(String.format("No se encontró el producto con ID: %s", productoId), causa);
        this.productoId = productoId;
    }

    public UUID getProductoId() {
        return productoId;
    }

    public String getDetalleError() {
        return String.format("ProductoNoEncontradoException: productoId=%s, mensaje=%s", 
                productoId != null ? productoId.toString() : "null", 
                getMessage());
    }
}