package com.gestionpedidos.domain.repository;

import com.gestionpedidos.domain.model.Producto;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interfaz del repositorio que define el contrato de persistencia para la entidad Producto.
 * Esta interfaz sigue el patrón Repository de DDD, aislando la lógica de acceso a datos
 * del dominio. La implementación concreta será proporcionada por la capa de infraestructura
 * mediante Spring Data JPA.
 */
public interface ProductoRepository {
    
    /**
     * Persiste un producto en el almacenamiento.
     * @param producto El producto a guardar
     * @return El producto persistido con su ID asignado
     */
    Producto save(Producto producto);
    
    /**
     * Busca un producto por su identificador único.
     * @param id El UUID del producto a buscar
     * @return Optional conteniendo el producto si existe, vacío si no
     */
    Optional<Producto> findById(UUID id);
    
    /**
     * Recupera todos los productos disponibles en el sistema.
     * @return Lista de todos los productos
     */
    List<Producto> findAll();
    
    /**
     * Elimina un producto por su identificador.
     * @param id El UUID del producto a eliminar
     */
    void deleteById(UUID id);
    
    /**
     * Busca productos por nombre exactoo parcial.
     * @param nombre El nombre o fragmento de nombre a buscar
     * @return Lista de productos que coinciden con el criterio
     */
    List<Producto> findByNombreContaining(String nombre);
    
    /**
     * Busca productos que tienen stock disponible.
     * @return Lista de productos con stock mayor a cero
     */
    List<Producto> findByStockGreaterThan(int cantidad);
    
    /**
     * Busca productos dentro de un rango de precios.
     * @param precioMinimo El precio mínimo del rango
     * @param precioMaximo El precio máximo del rango
     * @return Lista de productos dentro del rango de precios
     */
    List<Producto> findByPrecioBetween(BigDecimal precioMinimo, BigDecimal precioMaximo);
    
    /**
     * Verifica si existe un producto con el identificador dado.
     * @param id El UUID a verificar
     * @return true si existe el producto, false en caso contrario
     */
    boolean existsById(UUID id);
    
    /**
     * Actualiza el stock de un producto específico.
     * @param id El UUID del producto
     * @param nuevaCantidad La nueva cantidad de stock
     */
    void updateStock(UUID id, int nuevaCantidad);
}