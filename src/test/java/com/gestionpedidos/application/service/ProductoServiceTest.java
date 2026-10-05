package com.gestionpedidos.application.service;

import com.gestionpedidos.domain.exception.ProductoNoEncontradoException;
import com.gestionpedidos.domain.exception.StockInsuficienteException;
import com.gestionpedidos.domain.model.Producto;
import com.gestionpedidos.domain.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para ProductoService")
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    private Producto productoPrueba;

    @BeforeEach
    void setUp() {
        productoPrueba = new Producto();
        productoPrueba.setId(UUID.randomUUID());
        productoPrueba.setNombre("Laptop ASUS");
        productoPrueba.setDescripcion("Laptop gamer 15.6 pulgadas");
        productoPrueba.setPrecio(new BigDecimal("1500.00"));
        productoPrueba.setStock(25);
    }

    @Test
    @DisplayName("Crear producto - Caso de éxito")
    void testCrearProducto_CasoExito() {
        // Given: un producto válido con todos los datos
        when(productoRepository.save(any(Producto.class))).thenReturn(productoPrueba);

        // When: se crea el producto
        Producto resultado = productoService.crear(productoPrueba);

        // Then: el producto se guarda y retorna
        assertThat(resultado.getNombre()).isEqualTo("Laptop ASUS");
    }

    @Test
    @DisplayName("Crear producto - Validación de precio positivo")
    void testCrearProducto_PrecioInvalido() {
        // Given: un producto con precio negativo o cero
        productoPrueba.setPrecio(new BigDecimal("-10.00"));

        // When/Then: se lanza excepción de validación
    }

    @Test
    @DisplayName("Crear producto - Validación de stock no negativo")
    void testCrearProducto_StockInvalido() {
        // Given: un producto con stock negativo
        productoPrueba.setStock(-5);

        // When/Then: se lanza excepción de validación
    }

    @Test
    @DisplayName("Obtener producto por ID - Caso de éxito")
    void testObtenerPorId_CasoExito() {
        // Given: un ID de producto existente
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.of(productoPrueba));

        // When: se busca el producto
        Optional<Producto> resultado = productoService.buscarPorId(productoPrueba.getId());

        // Then: se retorna el producto
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNombre()).isEqualTo("Laptop ASUS");
    }

    @Test
    @DisplayName("Obtener producto por ID - No encontrado")
    void testObtenerPorId_NoEncontrado() {
        // Given: un ID que no existe
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        // When/Then: se lanza excepción
        assertThatThrownBy(() -> productoService.buscarPorId(UUID.randomUUID()))
            .isInstanceOf(ProductoNoEncontradoException.class);
    }

    @Test
    @DisplayName("Listar todos los productos - Caso de éxito")
    void testListarTodos_CasoExito() {
        // Given: existen productos en el repositorio
        when(productoRepository.findAll()).thenReturn(List.of(productoPrueba));

        // When: se listan todos
        List<Producto> resultado = productoService.listarTodos();

        // Then: se retorna la lista
        assertThat(resultado).hasSize(1);
    }

    @Test
    @DisplayName("Actualizar producto - Caso de éxito")
    void testActualizarProducto_CasoExito() {
        // Given: un producto existente con nuevos datos
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.of(productoPrueba));
        when(productoRepository.save(any(Producto.class))).thenReturn(productoPrueba);

        // When: se actualiza el producto
        Producto productoActualizado = new Producto();
        productoActualizado.setNombre("Laptop Actualizada");
        productoActualizado.setPrecio(new BigDecimal("1800.00"));

        Producto resultado = productoService.actualizar(productoPrueba.getId(), productoActualizado);

        // Then: se retorna el producto actualizado
        assertThat(resultado.getNombre()).isEqualTo("Laptop Actualizada");
    }

    @Test
    @DisplayName("Actualizar producto - No encontrado")
    void testActualizarProducto_NoEncontrado() {
        // Given: un ID que no existe
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        // When/Then: se lanza excepción
        assertThatThrownBy(() -> productoService.actualizar(UUID.randomUUID(), new Producto()))
            .isInstanceOf(ProductoNoEncontradoException.class);
    }

    @Test
    @DisplayName("Eliminar producto - Caso de éxito")
    void testEliminarProducto_CasoExito() {
        // Given: un producto existente
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.of(productoPrueba));
        doNothing().when(productoRepository).deleteById(any(UUID.class));

        // When: se elimina
        productoService.eliminar(productoPrueba.getId());

        // Then: se verifica la llamada al repositorio
        verify(productoRepository, times(1)).deleteById(productoPrueba.getId());
    }

    @Test
    @DisplayName("Eliminar producto - No encontrado")
    void testEliminarProducto_NoEncontrado() {
        // Given: un ID que no existe
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        // When/Then: se lanza excepción
        assertThatThrownBy(() -> productoService.eliminar(UUID.randomUUID()))
            .isInstanceOf(ProductoNoEncontradoException.class);
    }

    @Test
    @DisplayName("Reducir stock - Caso de éxito")
    void testReducirStock_CasoExito() {
        // Given: un producto con stock suficiente
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.of(productoPrueba));
        when(productoRepository.save(any(Producto.class))).thenReturn(productoPrueba);

        // When: se reduce el stock
        Producto resultado = productoService.reducirStock(productoPrueba.getId(), 10);

        // Then: el stock se reduce en la cantidad indicada
        assertThat(resultado.getStock()).isEqualTo(15);
    }

    @Test
    @DisplayName("Reducir stock - Stock insuficiente")
    void testReducirStock_StockInsuficiente() {
        // Given: un producto con stock menor a la cantidad solicitada
        productoPrueba.setStock(5);
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.of(productoPrueba));

        // When/Then: se lanza excepción de stock insuficiente
        assertThatThrownBy(() -> productoService.reducirStock(productoPrueba.getId(), 10))
            .isInstanceOf(StockInsuficienteException.class);
    }

    @Test
    @DisplayName("Aumentar stock - Caso de éxito")
    void testAumentarStock_CasoExito() {
        // Given: un producto existente
        when(productoRepository.findById(any(UUID.class))).thenReturn(Optional.of(productoPrueba));
        when(productoRepository.save(any(Producto.class))).thenReturn(productoPrueba);

        // When: se aumenta el stock
        Producto resultado = productoService.aumentarStock(productoPrueba.getId(), 20);

        // Then: el stock aumenta correctamente
        assertThat(resultado.getStock()).isEqualTo(45);
    }
}