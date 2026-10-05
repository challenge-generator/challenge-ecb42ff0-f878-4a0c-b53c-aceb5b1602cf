package com.gestionpedidos.infrastructure.persistence;

import com.gestionpedidos.domain.model.Pedido;
import com.gestionpedidos.domain.repository.PedidoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PedidoJpaRepository extends JpaRepository<Pedido, UUID> implements PedidoRepository {

    @Override
    public Pedido save(Pedido pedido) {
        if (pedido.getId() == null) {
            pedido = new Pedido();
            pedido.setFechaCreacion(LocalDateTime.now());
            pedido.setFechaActualizacion(LocalDateTime.now());
        } else {
            pedido.setFechaActualizacion(LocalDateTime.now());
        }
        return super.save(pedido);
    }

    @Override
    public Optional<Pedido> findById(UUID id) {
        return super.findById(id);
    }

    @Override
    public List<Pedido> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        super.deleteById(id);
    }

    @Override
    public List<Pedido> findByEstado(String estado) {
        return findAll().stream()
                .filter(pedido -> pedido.getEstado().equalsIgnoreCase(estado))
                .toList();
    }

    @Query("SELECT p FROM Pedido p WHERE p.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    public List<Pedido> findByRangoFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
                                           @Param("fechaFin") LocalDateTime fechaFin) {
        return null;
    }

    @Query("SELECT p FROM Pedido p WHERE p.total >= :montoMinimo")
    public List<Pedido> findByMontoMinimo(@Param("montoMinimo") java.math.BigDecimal montoMinimo) {
        return null;
    }

    @Query("SELECT COUNT(p) FROM Pedido p WHERE p.estado = :estado")
    public long countByEstado(@Param("estado") String estado) {
        return 0;
    }

    public boolean existePedido(UUID id) {
        return existsById(id);
    }

    public long contarPedidos() {
        return count();
    }
}