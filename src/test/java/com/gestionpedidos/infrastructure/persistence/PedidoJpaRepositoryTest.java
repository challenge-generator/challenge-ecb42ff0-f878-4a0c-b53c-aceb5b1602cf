package com.gestionpedidos.infrastructure.persistence;

import com.gestionpedidos.domain.model.Pedido;
import com.gestionpedidos.domain.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@DisplayName("Pruebas unitarias para PedidoJpaRepository")
class PedidoJpaRepositoryTest {

    @Autowired
    private PedidoJpaRepository pedidoJpaRepository;

    private Pedido pedidoDePrueba;

    @BeforeEach
    void setUp() {
        pedidoJpaRepository.deleteAll();
        
        Producto producto = new Producto();
        producto.setId(UUID.randomUUID());
        producto.setNombre("Producto Prueba");
        producto.setDescripcion("Descripción de prueba");
        producto.setPrecio(new BigDecimal("100.00"));
        producto.setStock(50);

        pedidoDePrueba = new Pedido();
        pedidoDePrueba.setId(UUID.randomUUID());
        pedidoDePrueba.setFechaCreacion(LocalDateTime.now());
        pedidoDePrueba.setFechaActualizacion(LocalDateTime.now());
        pedidoDePrueba.setEstado("PENDIENTE");
        pedidoDePrueba.setTotal(new BigDecimal("250.00"));
    }

    @Test
    @DisplayName("Guardar pedido persistido exitosamente")
    void guardar_pedido_debePersistirEnBaseDeDatos() {
        Pedido pedidoGuardado = pedidoJpaRepository.save(pedidoDePrueba);

        assertThat(pedidoGuardado).isNotNull();
        assertThat(pedidoGuardado.getId()).isEqualTo(pedidoDePrueba.getId());
        assertThat(pedidoGuardado.getEstado()).isEqualTo("PENDIENTE");
    }

    @Test
    @DisplayName("Buscar pedido por ID existente retorna optional con pedido")
    void findById_conIdExistente_debeRetornarOptionalConPedido() {
        Pedido pedidoGuardado = pedidoJpaRepository.save(pedidoDePrueba);

        Optional<Pedido> resultado = pedidoJpaRepository.findById(pedidoGuardado.getId());

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getId()).isEqualTo(pedidoGuardado.getId());
    }

    @Test
    @DisplayName("Buscar pedido por ID no existente retorna optional empty")
    void findById_conIdNoExistente_debeRetornarOptionalEmpty() {
        UUID idNoExistente = UUID.randomUUID();

        Optional<Pedido> resultado = pedidoJpaRepository.findById(idNoExistente);

        assertThat(resultado).isEmpty();
    }

    @Test
    @DisplayName("Listar todos los pedidos retorna todos los guardados")
    void findAll_debeRetornarTodosLosPedidos() {
        pedidoJpaRepository.save(pedidoDePrueba);

        Pedido segundoPedido = new Pedido();
        segundoPedido.setId(UUID.randomUUID());
        segundoPedido.setFechaCreacion(LocalDateTime.now());
        segundoPedido.setFechaActualizacion(LocalDateTime.now());
        segundoPedido.setEstado("COMPLETADO");
        segundoPedido.setTotal(new BigDecimal("500.00"));
        pedidoJpaRepository.save(segundoPedido);

        List<Pedido> pedidos = pedidoJpaRepository.findAll();

        assertThat(pedidos).hasSize(2);
    }

    @Test
    @DisplayName("Buscar pedidos por estado retorna solo los del estado especificado")
    void findByEstado_debeRetornarSoloPedidosConEseEstado() {
        pedidoJpaRepository.save(pedidoDePrueba);

        Pedido pedidoCompletado = new Pedido();
        pedidoCompletado.setId(UUID.randomUUID());
        pedidoCompletado.setFechaCreacion(LocalDateTime.now());
        pedidoCompletado.setFechaActualizacion(LocalDateTime.now());
        pedidoCompletado.setEstado("COMPLETADO");
        pedidoCompletado.setTotal(new BigDecimal("100.00"));
        pedidoJpaRepository.save(pedidoCompletado);

        List<Pedido> pedidosPendientes = pedidoJpaRepository.findByEstado("PENDIENTE");

        assertThat(pedidosPendientes).hasSize(1);
        assertThat(pedidosPendientes.get(0).getEstado()).isEqualTo("PENDIENTE");
    }

    @Test
    @DisplayName("Eliminar pedido por ID elimina correctamente")
    void deleteById_debeEliminarElPedido() {
        Pedido pedidoGuardado = pedidoJpaRepository.save(pedidoDePrueba);
        UUID idPedido = pedidoGuardado.getId();

        pedidoJpaRepository.deleteById(idPedido);

        Optional<Pedido> resultado = pedidoJpaRepository.findById(idPedido);
        assertThat(resultado).isEmpty();
    }
}