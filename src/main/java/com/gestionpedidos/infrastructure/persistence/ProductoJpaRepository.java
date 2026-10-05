package com.gestionpedidos.infrastructure.persistence;

import com.gestionpedidos.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductoJpaRepository extends JpaRepository<Producto, UUID> {

    Optional<Producto> findByNombre(String nombre);

    List<Producto> findByPrecioBetween(BigDecimal precioMin, BigDecimal precioMax);

    List<Producto> findByStockGreaterThan(int stockMinimo);

    List<Producto> findByStockLessThan(int stockMaximo);

    @Query("SELECT p FROM Producto p WHERE p.stock <= :stockMinimo AND p.stock > 0")
    List<Producto> findProductosConStockBajo(@Param("stockMinimo") int stockMinimo);

    @Query("SELECT p FROM Producto p WHERE p.stock = 0")
    List<Producto> findProductosAgotados();

    @Modifying
    @Query("UPDATE Producto p SET p.stock = p.stock - :cantidad WHERE p.id = :id AND p.stock >= :cantidad")
    int reducirStock(@Param("id") UUID id, @Param("cantidad") int cantidad);

    @Modifying
    @Query("UPDATE Producto p SET p.stock = p.stock + :cantidad WHERE p.id = :id")
    int aumentarStock(@Param("id") UUID id, @Param("cantidad") int cantidad);

    boolean existsByNombre(String nombre);

    long countByStockGreaterThan(int stockMinimo);

    @Query("SELECT p FROM Producto p ORDER BY p.precio DESC")
    List<Producto> findAllOrderByPrecioDesc();

    @Query("SELECT p FROM Producto p ORDER BY p.stock ASC")
    List<Producto> findAllOrderByStockAsc();
}