package com.gestionpedidos.infrastructure.config;

import com.gestionpedidos.domain.exception.PedidoNoEncontradoException;
import com.gestionpedidos.domain.exception.ProductoNoEncontradoException;
import com.gestionpedidos.domain.exception.StockInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleProductoNoEncontradoException(
            ProductoNoEncontradoException ex, WebRequest request) {
        return buildErrorResponse(
            HttpStatus.NOT_FOUND,
            "PRODUCTO_NO_ENCONTRADO",
            ex.getMessage(),
            request.getDescription(false)
        );
    }

    @ExceptionHandler(PedidoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handlePedidoNoEncontradoException(
            PedidoNoEncontradoException ex, WebRequest request) {
        return buildErrorResponse(
            HttpStatus.NOT_FOUND,
            "PEDIDO_NO_ENCONTRADO",
            ex.getMessage(),
            request.getDescription(false)
        );
    }

    @ExceptionHandler(StockInsuficienteException.class)
    public ResponseEntity<Map<String, Object>> handleStockInsuficienteException(
            StockInsuficienteException ex, WebRequest request) {
        return buildErrorResponse(
            HttpStatus.CONFLICT,
            "STOCK_INSUFICIENTE",
            ex.getMessage(),
            request.getDescription(false)
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        return buildErrorResponse(
            HttpStatus.BAD_REQUEST,
            "ARGUMENTO_INVALIDO",
            ex.getMessage(),
            request.getDescription(false)
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        String mensaje = String.format("El parámetro '%s' tiene un valor inválido: '%s'",
                ex.getName(), ex.getValue());
        return buildErrorResponse(
            HttpStatus.BAD_REQUEST,
            "TIPO_DE_PARAMETRO_INVALIDO",
            mensaje,
            request.getDescription(false)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(
            Exception ex, WebRequest request) {
        return buildErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "ERROR_INTERNO_DEL_SERVIDOR",
            "Ha ocurrido un error inesperado. Por favor, contacte al administrador.",
            request.getDescription(false)
        );
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(
            HttpStatus estado, String codigo, String mensaje, String path) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now().toString());
        errorResponse.put("status", estado.value());
        errorResponse.put("error", estado.getReasonPhrase());
        errorResponse.put("code", codigo);
        errorResponse.put("message", mensaje);
        errorResponse.put("path", path);
        return new ResponseEntity<>(errorResponse, estado);
    }
}