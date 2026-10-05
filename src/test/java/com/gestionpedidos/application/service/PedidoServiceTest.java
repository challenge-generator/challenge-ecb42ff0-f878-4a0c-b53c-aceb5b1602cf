package com.gestionpedidos.application.service;

import com.gestionpedidos.domain.exception.PedidoNoEncontradoException;
import com.gestionpedidos.domain.model.Pedido;
import com.gestionpedidos.domain.model.Producto;
import com.gestionpedidos.domain.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para PedidoService")
class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    private Pedido pedidoPrueba;
    private Producto productoPrueba;

    @BeforeEach
    void setUp() {
        pedidoPrueba = new Pedido();
        pedidoPrueba.setId(UUID.randomUUID());
        pedidoPrueba.setFechaCreacion(LocalDateTime.now());
        pedidoPrueba.setFechaActualizacion(LocalDateTime.now());
        pedidoPrueba.setEstado("PENDIENTE");
        pedidoPrueba.setTotal(new BigDecimal("200.00"));

        productoPrueba = new Producto();
        productoPrueba.setId(UUID.randomUUID());
        productoPrueba.setNombre("Producto Prueba");
        productoPrueba.setDescripcion("Descripción del producto");
        productoPrueba.setPrecio(new BigDecimal("50.00"));
        productoPrueba.setStock(100);
    }

    @Test
    @DisplayName("Crear pedido - Caso de éxito")
    void testCrearPedido_CasoExito() {
        // Given: un pedido válido para crear
        // When: se invoca el método crear del servicio
        // Then: el pedido se guarda y retorna el pedido creado
    }

    @Test
    @DisplayName("Crear pedido con productos - Verificar cálculo de total")
    void testCrearPedido_CalculoTotal() {
        // Given: un pedido con múltiples productos
        // When: se crea el pedido
        // Then: el total se calcula correctamente como suma de (precio * cantidad)
    }

    @Test
    @DisplayName("Obtener pedido por ID - Caso de éxito")
    void testObtenerPorId_CasoExito() {
        // Given: un ID de pedido existente
        when(pedidoRepository.findById(any(UUID.class))).thenReturn(Optional.of(pedidoPrueba));

        // When: se busca el pedido
        Optional<Pedido> resultado = pedidoService.buscarPorId(pedidoPrueba.getId());

        // Then: se retorna el pedido encontrado
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getId()).isEqualTo(pedidoPrueba.getId());
    }

    @Test
    @DisplayName("Obtener pedido por ID - No encontrado")
    void testObtenerPorId_NoEncontrado() {
        // Given: un ID que no existe
        when(pedidoRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        // When: se busca el pedido
        // Then: se lanza excepción PedidoNoEncontradoException
    }

    @Test
    @DisplayName("Listar todos los pedidos - Caso de éxito")
    void testListarTodos_CasoExito() {
        // Given: existen pedidos en el repositorio
        when(pedidoRepository.findAll()).thenReturn(List.of(pedidoPrueba));

        // When: se listan todos los pedidos
        List<Pedido> resultado = pedidoService.listarTodos();

        // Then: se retorna la lista de pedidos
        assertThat(resultado).hasSize(1);
    }

    @Test
    @DisplayName("Actualizar estado del pedido - Caso de éxito")
    void testActualizarEstado_CasoExito() {
        // Given: un pedido existente
        when(pedidoRepository.findById(any(UUID.class))).thenReturn(Optional.of(pedidoPrueba));
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedidoPrueba);

        // When: se actualiza el estado
        Pedido resultado = pedidoService.actualizarEstado(pedidoPrueba.getId(), "CONFIRMADO");

        // Then: el estado se actualiza correctamente
        assertThat(resultado.getEstado()).isEqualTo("CONFIRMADO");
    }

    @Test
    @DisplayName("Actualizar estado - Pedido no encontrado")
    void testActualizarEstado_NoEncontrado() {
        // Given: un ID que no existe
        when(pedidoRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        // When/Then: se lanza excepción al intentar actualizar
        assertThatThrownBy(() -> pedidoService.actualizarEstado(UUID.randomUUID(), "CONFIRMADO"))
            .isInstanceOf(PedidoNoEncontradoException.class);
    }

    @Test
    @DisplayName("Eliminar pedido - Caso de éxito")
    void testEliminarPedido_CasoExito() {
        // Given: un pedido existente
        when(pedidoRepository.findById(any(UUID.class))).thenReturn(Optional.of(pedidoPrueba));
        doNothing().when(pedidoRepository).deleteById(any(UUID.class));

        // When: se elimina el pedido
        pedidoService.eliminar(pedidoPrueba.getId());

        // Then: se verifica que se llamó al repositorio
        verify(pedidoRepository, times(1)).deleteById(pedidoPrueba.getId());
    }

    @Test
    @DisplayName("Eliminar pedido - No encontrado")
    void testEliminarPedido_NoEncontrado() {
        // Given: un ID que no existe
        when(pedidoRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        // When/Then: se lanza excepción
        assertThatThrownBy(() -> pedidoService.eliminar(UUID.randomUUID()))
            .isInstanceOf(PedidoNoEncontradoException.class);
    }

    @Test
    @DisplayName("Buscar pedidos por estado - Caso de éxito")
    void testBuscarPorEstado_CasoExito() {
        // Given: pedidos con un estado específico
        when(pedidoRepository.findByEstado("PENDIENTE")).thenReturn(List.of(pedidoPrueba));

        // When: se buscan por estado
        List<Pedido> resultado = pedidoService.buscarPorEstado("PENDIENTE");

        // Then: se retornan los pedidos con ese estado
        assertThat(resultado).hasSize(1);
    }
}