package com.gestionpedidos.domain.exception;


import com.gestionpedidos.domain.model.Pedido;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Excepción personalizada que se lanza cuando se intenta acceder a un pedido
 * que no existe en el sistema. Esta excepción es parte del manejo de errores
 * del dominio y se utiliza para comunicar violations de las reglas de negocio
 * relacionadas con la existencia de pedidos.
 */
public class PedidoNoEncontradoException extends RuntimeException {
    
    private final UUID pedidoId;
    private final String numeroPedido;
    private final LocalDateTime timestamp;
    private final String contextoOperacion;
    
    /**
     * Constructor por defecto que inicializa la excepción con un mensaje genérico.
     */
    public PedidoNoEncontradoException() {
        super("El pedido solicitado no fue encontrado en el sistema");
        this.pedidoId = null;
        this.numeroPedido = null;
        this.timestamp = LocalDateTime.now();
        this.contextoOperacion = null;
    }
    
    /**
     * Constructor con mensaje personalizado.
     * @param mensaje Descripción específica del error
     */
    public PedidoNoEncontradoException(String mensaje) {
        super(mensaje);
        this.pedidoId = null;
        this.numeroPedido = null;
        this.timestamp = LocalDateTime.now();
        this.contextoOperacion = null;
    }
    
    /**
     * Constructor con identificador UUID del pedido.
     * @param pedidoId El UUID del pedido que no se encontró
     */
    public PedidoNoEncontradoException(UUID pedidoId) {
        super(String.format("No se encontró el pedido con ID: %s", pedidoId));
        this.pedidoId = pedidoId;
        this.numeroPedido = null;
        this.timestamp = LocalDateTime.now();
        this.contextoOperacion = null;
    }
    
    /**
     * Constructor con información completa del error.
     * @param pedidoId Identificador único del pedido
     * @param numeroPedido Número legible del pedido
     * @param contextoOperación Descripción de la operación que intentó acceder al pedido
     */
    public PedidoNoEncontradoException(UUID pedidoId, String numeroPedido, 
                                        String contextoOperacion) {
        super(String.format("Pedido no encontrado. ID: %s, Número: %s, Contexto: %s", 
               pedidoId, numeroPedido, contextoOperacion));
        this.pedidoId = pedidoId;
        this.numeroPedido = numeroPedido;
        this.timestamp = LocalDateTime.now();
        this.contextoOperacion = contextoOperacion;
    }
    
    /**
     * Constructor que incluye la causa original de la excepción.
     * @param mensaje Mensaje descriptivo
     * @param causa Excepción original que causó este error
     */
    public PedidoNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.pedidoId = null;
        this.numeroPedido = null;
        this.timestamp = LocalDateTime.now();
        this.contextoOperacion = null;
    }
    
    /**
     * Constructor con causa e identificador del pedido.
     * @param pedidoId UUID del pedido no encontrado
     * @param causa Excepción original
     */
    public PedidoNoEncontradoException(UUID pedidoId, Throwable causa) {
        super(String.format("No se encontró el pedido con ID: %s", pedidoId), causa);
        this.pedidoId = pedidoId;
        this.numeroPedido = null;
        this.timestamp = LocalDateTime.now();
        this.contextoOperacion = null;
    }
    
    /**
     * Obtiene el identificador UUID del pedido no encontrado.
     * @return UUID del pedido o null si no se proporcionó
     */
    public UUID getPedidoId() {
        return pedidoId;
    }
    
    /**
     * Obtiene el número legible del pedido.
     * @return Número del pedido o null si no se proporcionó
     */
    public String getNumeroPedido() {
        return numeroPedido;
    }
    
    /**
     * Obtiene la marca de tiempo cuando ocurrió el error.
     * @return LocalDateTime del momento de la excepción
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    /**
     * Obtiene el contexto de la operación que intentó acceder al pedido.
     * @return Descripción del contexto o null
     */
    public String getContextoOperacion() {
        return contextoOperacion;
    }
    
    /**
     * Proporciona un mensaje de error estructurado para logging.
     * @return Cadena con formato JSON para trazabilidad
     */
    public String getDetalleError() {
        return String.format("{" +
            "\"tipo\": \"PedidoNoEncontradoException\"," +
            "\"pedidoId\": \"%s\"," +
            "\"numeroPedido\": \"%s\"," +
            "\"timestamp\": \"%s\"," +
            "\"contexto\": \"%s\"," +
            "\"mensaje\": \"%s\"" +
            "}",
            pedidoId != null ? pedidoId.toString() : "null",
            numeroPedido != null ? numeroPedido : "null",
            timestamp != null ? timestamp.toString() : "null",
            contextoOperacion != null ? contextoOperacion : "null",
            getMessage());
    }
    
    /**
     * Verifica si la excepción tiene información de UUID del pedido.
     * @return true si tiene ID de pedido, false en caso contrario
     */
    public boolean tienePedidoId() {
        return pedidoId != null;
    }
    
    /**
     * Verifica si la excepción tiene información del número de pedido.
     * @return true si tiene número de pedido, false en caso contrario
     */
    public boolean tieneNumeroPedido() {
        return numeroPedido != null && !numeroPedido.isEmpty();
    }
}