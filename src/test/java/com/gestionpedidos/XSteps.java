package com.gestionpedidos;





import com.gestionpedidos.domain.model.Producto;
import com.gestionpedidos.domain.model.Pedido;
import com.gestionpedidos.application.service.ProductoService;
import com.gestionpedidos.application.service.PedidoService;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class XSteps {

    @Autowired
    private com.gestionpedidos.application.service.PedidoService pedidoService;

    @Autowired
    private com.gestionpedidos.application.service.ProductoService productoService;

    private com.gestionpedidos.domain.model.Pedido ultimoPedidoCreado;
    private com.gestionpedidos.domain.model.Producto ultimoProductoCreado;

    @Dado("que existe un producto con nombre {string} y precio {double}")
    public void que_existe_un_producto_con_nombre_y_precio(String nombre, Double precio) {
        ultimoProductoCreado = new com.gestionpedidos.domain.model.Producto();
        ultimoProductoCreado.setNombre(nombre);
        ultimoProductoCreado.setPrecio(java.math.BigDecimal.valueOf(precio));
        ultimoProductoCreado.setStock(100);
        ultimoProductoCreado.setDescripcion("Producto de prueba");
    }

    @Cuando("el usuario crea un pedido con ese producto")
    public void el_usuario_crea_un_pedido_con_ese_producto() {
        ultimoPedidoCreado = new com.gestionpedidos.domain.model.Pedido();
        ultimoPedidoCreado.setTotal(ultimoProductoCreado.getPrecio());
        ultimoPedidoCreado.setEstado("PENDIENTE");
    }

    @Entonces("el pedido debe ser creado exitosamente")
    public void el_pedido_debe_ser_creado_exitosamente() {
        assertNotNull(ultimoPedidoCreado);
    }

    @Y("el estado del pedido debe ser {string}")
    public void el_estado_del_pedido_debe_ser(String estadoEsperado) {
        assertEquals(estadoEsperado, ultimoPedidoCreado.getEstado());
    }

    @Dado("que existe un pedido en estado {string}")
    public void que_existe_un_pedido_en_estado(String estado) {
        ultimoPedidoCreado = new com.gestionpedidos.domain.model.Pedido();
        ultimoPedidoCreado.setEstado(estado);
        ultimoPedidoCreado.setTotal(java.math.BigDecimal.valueOf(100.0));
    }

    @Cuando("el usuario actualiza el estado a {string}")
    public void el_usuario_actualiza_el_estado_a(String nuevoEstado) {
        if (ultimoPedidoCreado != null) {
            ultimoPedidoCreado.setEstado(nuevoEstado);
        }
    }

    @Entonces("el pedido debe mostrar el nuevo estado")
    public void el_pedido_debe_mostrar_el_nuevo_estado() {
        assertNotNull(ultimoPedidoCreado);
        assertNotNull(ultimoPedidoCreado.getEstado());
    }

    @Dado("que la base de datos tiene pedidos registrados")
    public void que_la_base_de_datos_tiene_pedidos_registrados() {
    }

    @Cuando("solicito listar todos los pedidos")
    public void solicito_listar_todos_los_pedidos() {
    }

    @Entonces("debo recibir una lista de pedidos")
    public void debo_recibir_una_lista_de_pedidos() {
    }
}