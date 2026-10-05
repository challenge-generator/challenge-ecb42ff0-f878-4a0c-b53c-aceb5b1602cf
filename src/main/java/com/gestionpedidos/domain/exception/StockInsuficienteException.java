package com.gestionpedidos.domain.exception;

import java.util.UUID;

/**
 * Excepción personalizada que se lanza cuando una operación requiere más stock
 * del disponible actualmente para un producto. Esta excepción es parte del
 * manejo de errores del dominio y comunica una violación de las reglas de
 * negocio relacionadas con el inventario.
 */
public class StockInsuficienteException extends RuntimeException {
    
    private final UUID productoId;
    private final String nombreProducto;
    private final int stockActual;
    private final int stockRequerido;
    
    /**
     * Constructor por defecto que inicializa la excepción con un mensaje genérico.
     */
    public StockInsuficienteException() {
        super("No hay suficiente stock disponible para completar la operación");
        this.productoId = null;
        this.nombreProducto = null;
        this.stockActual = 0;
        this.stockRequerido = 0;
    }
    
    /**
     * Constructor con mensaje personalizado.
     * @param mensaje Descripción específica del error
     */
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
        this.productoId = null;
        this.nombreProducto = null;
        this.stockActual = 0;
        this.stockRequerido = 0;
    }
    
    /**
     * Constructor con información detallada del error de stock.
     * @param productoId Identificador único del producto
     * @param nombreProducto Nombre del producto
     * @param stockActual Cantidad actual disponible en inventario
     * @param stockRequerido Cantidad solicitada que excede el stock
     */
    public StockInsuficienteException(UUID productoId, String nombreProducto, 
                                       int stockActual, int stockRequerido) {
        super(String.format("Stock insuficiente para el producto '%s' (ID: %s). " +
               "Stock actual: %d, Stock requerido: %d", 
               nombreProducto, productoId, stockActual, stockRequerido));
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.stockActual = stockActual;
        this.stockRequerido = stockRequerido;
    }
    
    /**
     * Constructor que incluye la causa original de la excepción.
     * @param mensaje Mensaje descriptivo
     * @param causa Excepción original que causó este error
     */
    public StockInsuficienteException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.productoId = null;
        this.nombreProducto = null;
        this.stockActual = 0;
        this.stockRequerido = 0;
    }
    
    /**
     * Obtiene el identificador del producto con stock insuficiente.
     * @return UUID del producto o null si no se proporcionó
     */
    public UUID getProductoId() {
        return productoId;
    }
    
    /**
     * Obtiene el nombre del producto con stock insuficiente.
     * @return Nombre del producto o null si no se proporcionó
     */
    public String getNombreProducto() {
        return nombreProducto;
    }
    
    /**
     * Obtiene la cantidad de stock disponible actualmente.
     * @return Entero con la cantidad en inventario
     */
    public int getStockActual() {
        return stockActual;
    }
    
    /**
     * Obtiene la cantidad de stock que se intentó consumir.
     * @return Entero con la cantidad requerida
     */
    public int getStockRequerido() {
        return stockRequerido;
    }
    
    /**
     * Calcula la diferencia entre el stock requerido y el disponible.
     * @return Entero con la cantidad faltante (negativo si hay exceso)
     */
    public int getStockFaltante() {
        return stockRequerido - stockActual;
    }
    
    /**
     * Proporciona información detallada del error en formato estructurado.
     * @return Cadena con formato JSON-like para logging
     */
    public String getDetalleError() {
        return String.format("{" +
            "\"error\": \"StockInsuficienteException\"," +
            "\"productoId\": \"%s\"," +
            "\"nombreProducto\": \"%s\"," +
            "\"stockActual\": %d," +
            "\"stockRequerido\": %d," +
            "\"stockFaltante\": %d" +
            "}", 
            productoId != null ? productoId.toString() : "null",
            nombreProducto != null ? nombreProducto : "null",
            stockActual, stockRequerido, getStockFaltante());
    }
}