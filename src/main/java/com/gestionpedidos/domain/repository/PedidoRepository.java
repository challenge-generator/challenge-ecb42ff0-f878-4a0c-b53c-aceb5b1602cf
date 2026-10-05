package com.gestionpedidos.domain.repository;

import com.gestionpedidos.domain.model.Pedido;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository {
    Pedido save(Pedido pedido);
    Optional<Pedido> findById(UUID id);
    List<Pedido> findAll();
    void deleteById(UUID id);
    List<Pedido> findByEstado(String estado);
}