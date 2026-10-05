# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `RunCucumberTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Archivos que la arquitectura del reto declara y no estan

Creálos con implementacion real, en la capa que les corresponde:

- `XSteps.java`

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `RunCucumberTest.java` — `io.cucumber.junit`: El import io.cucumber.junit.platform.Cucumber pertenece a io.cucumber.junit, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/gestionpedidos/XSteps.java` — `io.cucumber.java`: El import io.cucumber.java.es.Cuando pertenece a io.cucumber.java, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/gestionpedidos/domain/model/Pedido.java` — `Producto.getPrecio`: Se invoca `getPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java` — `Pedido.getId`: Se invoca `getId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java` — `Pedido.setFechaCreacion`: Se invoca `setFechaCreacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java` — `Pedido.setFechaActualizacion`: Se invoca `setFechaActualizacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java` — `Pedido.getEstado`: Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.productos`: Se invoca `productos` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.clienteId`: Se invoca `clienteId` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.nuevoEstado`: Se invoca `nuevoEstado` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.productoId`: Se invoca `productoId` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.cantidad`: Se invoca `cantidad` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `Pedido.getTotal`: Se invoca `getTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.obtenerTodosLosProductos`: Se invoca `obtenerTodosLosProductos` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.buscarPorId`: Se invoca `buscarPorId` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.buscarPorNombre`: Se invoca `buscarPorNombre` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.obtenerProductosConStockBajo`: Se invoca `obtenerProductosConStockBajo` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.nombre`: Se invoca `nombre` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.descripcion`: Se invoca `descripcion` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.precio`: Se invoca `precio` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.stockInicial`: Se invoca `stockInicial` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.actualizarStock`: Se invoca `actualizarStock` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.cantidad`: Se invoca `cantidad` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Producto.getStock`: Se invoca `getStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Producto.getNombre`: Se invoca `getNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `PedidoState.isBlank`: Se invoca `isBlank` sobre `PedidoState`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `PedidoState.toUpperCase`: Se invoca `toUpperCase` sobre `PedidoState`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Pedido.getEstado`: Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `PedidoState.puedeTransicionar`: Se invoca `puedeTransicionar` sobre `PedidoState`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `PedidoState.esFinal`: Se invoca `esFinal` sobre `PedidoState`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Pedido.getProductos`: Se invoca `getProductos` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Pedido.getTotal`: Se invoca `getTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setId`: Se invoca `setId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setNombre`: Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setDescripcion`: Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setPrecio`: Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setStock`: Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.getId`: Se invoca `getId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.getStock`: Se invoca `getStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.getNombre`: Se invoca `getNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setId`: Se invoca `setId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setFechaCreacion`: Se invoca `setFechaCreacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setFechaActualizacion`: Se invoca `setFechaActualizacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setEstado`: Se invoca `setEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setTotal`: Se invoca `setTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setId`: Se invoca `setId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setFechaCreacion`: Se invoca `setFechaCreacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setFechaActualizacion`: Se invoca `setFechaActualizacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setEstado`: Se invoca `setEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setTotal`: Se invoca `setTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setId`: Se invoca `setId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setNombre`: Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setDescripcion`: Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setPrecio`: Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setStock`: Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.getId`: Se invoca `getId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.get`: Se invoca `get` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `PedidoService.listarTodos`: Se invoca `listarTodos` sobre `PedidoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.getEstado`: Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `PedidoService.eliminar`: Se invoca `eliminar` sobre `PedidoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setId`: Se invoca `setId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setNombre`: Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setDescripcion`: Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setPrecio`: Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setStock`: Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.crear`: Se invoca `crear` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.getNombre`: Se invoca `getNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.buscarPorId`: Se invoca `buscarPorId` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.getId`: Se invoca `getId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.get`: Se invoca `get` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.listarTodos`: Se invoca `listarTodos` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.actualizar`: Se invoca `actualizar` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.eliminar`: Se invoca `eliminar` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.getStock`: Se invoca `getStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `PedidoJpaRepository.deleteAll`: Se invoca `deleteAll` sobre `PedidoJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setId`: Se invoca `setId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setNombre`: Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setDescripcion`: Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setPrecio`: Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setStock`: Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setId`: Se invoca `setId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setFechaCreacion`: Se invoca `setFechaCreacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setFechaActualizacion`: Se invoca `setFechaActualizacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setEstado`: Se invoca `setEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setTotal`: Se invoca `setTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.getId`: Se invoca `getId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.getEstado`: Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.setNombre`: Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.setPrecio`: Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.setStock`: Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.setDescripcion`: Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/XSteps.java` — `Pedido.setTotal`: Se invoca `setTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.getPrecio`: Se invoca `getPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/XSteps.java` — `Pedido.setEstado`: Se invoca `setEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/gestionpedidos/XSteps.java` — `Pedido.getEstado`: Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean test-compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Seniority Senior

### Brecha de conocimiento
Demuestra un dominio avanzado en al menos uno (1) de los siguientes lenguajes de Programación Orientada a Objetos: Java, Python, dart, JavaScript, TypeScript., en temas clave como: conexiones a base de datos, manejo de excepciones, interfaces, clases abstractas, colecciones, uso de bibliotecas/frameworks, patrones de diseño orientados a objetos, herramientas de pruebas unitarias

### Misión / candidato
Candidato Senior en Calidad de Software con experiencia en automatización

### Reto
- Tema: Implementación de programación orientada a objetos (POO) - avanzado
- Seniority: senior-l2
- Tipo: practical
- Título: Desarrollo de un sistema de gestión de pedidos utilizando POO avanzada
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Modelado de entidades y relaciones — objetivo: Definir las clases y relaciones necesarias para representar pedidos y productos en el sistema. — entregable (NO resolver): Diagrama de clases y relaciones, y las definiciones de clases en código.
- Fase 2: Conexión a la base de datos — objetivo: Implementar la conexión a la base de datos para almacenar y recuperar información de pedidos y productos. — entregable (NO resolver): Código que establece la conexión a la base de datos y métodos CRUD para pedidos y productos.
- Fase 3: Implementación de patrones de diseño — objetivo: Aplicar patrones de diseño orientados a objetos para mejorar la estructura y mantenibilidad del código. — entregable (NO resolver): Código que implementa los patrones de diseño seleccionados.
- Fase 4: Realización de pruebas unitarias — objetivo: Escribir y ejecutar pruebas unitarias para verificar el funcionamiento correcto del sistema. — entregable (NO resolver): Código de pruebas unitarias y resultados de ejecución.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.0</version>
        <relativePath/>
    </parent>
    <groupId>com.gestionpedidos</groupId>
    <artifactId>gestion-pedidos</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>gestion-pedidos</name>
    <description>Sistema de gestión de pedidos para tienda en línea</description>
    <properties>
        <java.version>21</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <version>3.25.3</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
        </repository>
    </repositories>
</project>

// === ARCHIVO: src/main/java/com/gestionpedidos/GestionPedidosApplication.java ===
package com.gestionpedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GestionPedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionPedidosApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
spring.application.name=gestion-pedidos

# Configuración de la base de datos H2 en memoria
spring.datasource.url=jdbc:h2:mem:gestionpedidosdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración de H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuración JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true

# Configuración del puerto del servidor
server.port=8080

# Configuración de logging
logging.level.org.springframework.web=INFO
logging.level.org.hibernate=INFO

// === ARCHIVO: src/main/java/com/gestionpedidos/domain/model/Pedido.java ===
package com.gestionpedidos.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Pedido {
    private UUID id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private String estado;
    private BigDecimal total;
    private List<ProductoPedido> productos;
    
    public Pedido() {
        this.id = UUID.randomUUID();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = "PENDIENTE";
        this.total = BigDecimal.ZERO;
    }
    
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        
        ProductoPedido productoPedido = new ProductoPedido(producto, cantidad);
        this.productos.add(productoPedido);
        this.total = this.total.add(producto.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
    }
    
    public void actualizarEstado(String nuevoEstado) {
        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
        }
        this.estado = nuevoEstado;
        this.fechaActualizacion = LocalDateTime.now();
    }
    
    public static class ProductoPedido {
        private Producto producto;
        private int cantidad;
        
        public ProductoPedido(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }
        
        public Producto getProducto() {
            return producto;
        }
        
        public int getCantidad() {
            return cantidad;
        }
    }
}

// === ARCHIVO: src/main/java/com/gestionpedidos/domain/model/Producto.java ===
package com.gestionpedidos.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Producto {
    private UUID id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;
    
    public Producto() {
        this.id = UUID.randomUUID();
    }
    
    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        if (this.stock < cantidad) {
            throw new IllegalStateException("Stock insuficiente");
        }
        this.stock -= cantidad;
    }
    
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        this.stock += cantidad;
    }
}

// === ARCHIVO: src/main/java/com/gestionpedidos/domain/repository/PedidoRepository.java ===
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

// === ARCHIVO: src/main/java/com/gestionpedidos/domain/repository/ProductoRepository.java ===
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

// === ARCHIVO: src/main/java/com/gestionpedidos/domain/exception/StockInsuficienteException.java ===
package com.gestionpedidos.domain.exception;

import java.util.UUID;

/**
 * Excepción personalizada que se lanza cuando una operación requiere más stock
 * del disponible actualmente para un producto. Esta excepción es parte del
 * manejo de errores del dominio y comunica una violación de las reglas de
 * negocio relacionadas con el inventario.
 */
public class StockInsuficienteException extends RuntimeException {
    
    private final UUID productoId;
    private final String nombreProducto;
    private final int stockActual;
    private final int stockRequerido;
    
    /**
     * Constructor por defecto que inicializa la excepción con un mensaje genérico.
     */
    public StockInsuficienteException() {
        super("No hay suficiente stock disponible para completar la operación");
        this.productoId = null;
        this.nombreProducto = null;
        this.stockActual = 0;
        this.stockRequerido = 0;
    }
    
    /**
     * Constructor con mensaje personalizado.
     * @param mensaje Descripción específica del error
     */
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
        this.productoId = null;
        this.nombreProducto = null;
        this.stockActual = 0;
        this.stockRequerido = 0;
    }
    
    /**
     * Constructor con información detallada del error de stock.
     * @param productoId Identificador único del producto
     * @param nombreProducto Nombre del producto
     * @param stockActual Cantidad actual disponible en inventario
     * @param stockRequerido Cantidad solicitada que excede el stock
     */
    public StockInsuficienteException(UUID productoId, String nombreProducto, 
                                       int stockActual, int stockRequerido) {
        super(String.format("Stock insuficiente para el producto '%s' (ID: %s). " +
               "Stock actual: %d, Stock requerido: %d", 
               nombreProducto, productoId, stockActual, stockRequerido));
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.stockActual = stockActual;
        this.stockRequerido = stockRequerido;
    }
    
    /**
     * Constructor que incluye la causa original de la excepción.
     * @param mensaje Mensaje descriptivo
     * @param causa Excepción original que causó este error
     */
    public StockInsuficienteException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.productoId = null;
        this.nombreProducto = null;
        this.stockActual = 0;
        this.stockRequerido = 0;
    }
    
    /**
     * Obtiene el identificador del producto con stock insuficiente.
     * @return UUID del producto o null si no se proporcionó
     */
    public UUID getProductoId() {
        return productoId;
    }
    
    /**
     * Obtiene el nombre del producto con stock insuficiente.
     * @return Nombre del producto o null si no se proporcionó
     */
    public String getNombreProducto() {
        return nombreProducto;
    }
    
    /**
     * Obtiene la cantidad de stock disponible actualmente.
     * @return Entero con la cantidad en inventario
     */
    public int getStockActual() {
        return stockActual;
    }
    
    /**
     * Obtiene la cantidad de stock que se intentó consumir.
     * @return Entero con la cantidad requerida
     */
    public int getStockRequerido() {
        return stockRequerido;
    }
    
    /**
     * Calcula la diferencia entre el stock requerido y el disponible.
     * @return Entero con la cantidad faltante (negativo si hay exceso)
     */
    public int getStockFaltante() {
        return stockRequerido - stockActual;
    }
    
    /**
     * Proporciona información detallada del error en formato estructurado.
     * @return Cadena con formato JSON-like para logging
     */
    public String getDetalleError() {
        return String.format("{" +
            "\"error\": \"StockInsuficienteException\"," +
            "\"productoId\": \"%s\"," +
            "\"nombreProducto\": \"%s\"," +
            "\"stockActual\": %d," +
            "\"stockRequerido\": %d," +
            "\"stockFaltante\": %d" +
            "}", 
            productoId != null ? productoId.toString() : "null",
            nombreProducto != null ? nombreProducto : "null",
            stockActual, stockRequerido, getStockFaltante());
    }
}

// === ARCHIVO: src/main/java/com/gestionpedidos/domain/exception/PedidoNoEncontradoException.java ===
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

// === ARCHIVO: src/main/java/com/gestionpedidos/domain/exception/ProductoNoEncontradoException.java ===
package com.gestionpedidos.domain.exception;

import java.util.UUID;

public class ProductoNoEncontradoException extends RuntimeException {

    private final UUID productoId;

    public ProductoNoEncontradoException(UUID productoId) {
        super(String.format("No se encontró el producto con ID: %s", productoId));
        this.productoId = productoId;
    }

    public ProductoNoEncontradoException(UUID productoId, String mensajePersonalizado) {
        super(mensajePersonalizado);
        this.productoId = productoId;
    }

    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
        this.productoId = null;
    }

    public ProductoNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.productoId = null;
    }

    public ProductoNoEncontradoException(UUID productoId, Throwable causa) {
        super(String.format("No se encontró el producto con ID: %s", productoId), causa);
        this.productoId = productoId;
    }

    public UUID getProductoId() {
        return productoId;
    }

    public String getDetalleError() {
        return String.format("ProductoNoEncontradoException: productoId=%s, mensaje=%s", 
                productoId != null ? productoId.toString() : "null", 
                getMessage());
    }
}

// === ARCHIVO: src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java ===
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

// === ARCHIVO: src/main/java/com/gestionpedidos/infrastructure/persistence/ProductoJpaRepository.java ===
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

// === ARCHIVO: src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java ===
package com.gestionpedidos.interfaces.rest;

import com.gestionpedidos.application.service.PedidoService;
import com.gestionpedidos.domain.exception.PedidoNoEncontradoException;
import com.gestionpedidos.domain.model.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable UUID id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pedido>> buscarPorEstado(@PathVariable String estado) {
        List<Pedido> pedidos = pedidoService.buscarPorEstado(estado);
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody CrearPedidoRequest request) {
        Pedido pedido = pedidoService.crearPedido(request.productos(), request.clienteId());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Pedido> actualizarEstado(
            @PathVariable UUID id,
            @RequestBody ActualizarEstadoRequest request) {
        try {
            Pedido pedido = pedidoService.actualizarEstado(id, request.nuevoEstado());
            return ResponseEntity.ok(pedido);
        } catch (PedidoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/agregar-producto")
    public ResponseEntity<Pedido> agregarProducto(
            @PathVariable UUID id,
            @RequestBody AgregarProductoRequest request) {
        try {
            Pedido pedido = pedidoService.agregarProducto(id, request.productoId(), request.cantidad());
            return ResponseEntity.ok(pedido);
        } catch (PedidoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable UUID id) {
        try {
            pedidoService.eliminarPedido(id);
            return ResponseEntity.noContent().build();
        } catch (PedidoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<BigDecimal> obtenerTotal(@PathVariable UUID id) {
        return pedidoService.buscarPorId(id)
                .map(pedido -> ResponseEntity.ok(pedido.getTotal()))
                .orElse(ResponseEntity.notFound().build());
    }

    public record CrearPedidoRequest(List<ProductoCantidad> productos, UUID clienteId) {}
    public record ProductoCantidad(UUID productoId, int cantidad) {}
    public record ActualizarEstadoRequest(String nuevoEstado) {}
    public record AgregarProductoRequest(UUID productoId, int cantidad) {}
}

// === ARCHIVO: src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java ===
package com.gestionpedidos.interfaces.rest;

import com.gestionpedidos.application.service.ProductoService;
import com.gestionpedidos.domain.exception.ProductoNoEncontradoException;
import com.gestionpedidos.domain.exception.StockInsuficienteException;
import com.gestionpedidos.domain.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarTodos() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable UUID id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarPorNombre(@RequestParam String nombre) {
        List<Producto> productos = productoService.buscarPorNombre(nombre);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/stock-bajo")
    public ResponseEntity<List<Producto>> productosConStockBajo(@RequestParam(defaultValue = "10") int umbral) {
        List<Producto> productos = productoService.obtenerProductosConStockBajo(umbral);
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoRequest request) {
        Producto producto = productoService.crearProducto(
                request.nombre(),
                request.descripcion(),
                request.precio(),
                request.stockInicial()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable UUID id,
            @RequestBody ProductoRequest request) {
        try {
            Producto producto = productoService.actualizarProducto(
                    id,
                    request.nombre(),
                    request.descripcion(),
                    request.precio()
            );
            return ResponseEntity.ok(producto);
        } catch (ProductoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Producto> actualizarStock(
            @PathVariable UUID id,
            @RequestBody ActualizarStockRequest request) {
        try {
            Producto producto = productoService.actualizarStock(id, request.cantidad());
            return ResponseEntity.ok(producto);
        } catch (ProductoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable UUID id) {
        try {
            productoService.eliminarProducto(id);
            return ResponseEntity.noContent().build();
        } catch (ProductoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/reducir-stock")
    public ResponseEntity<Producto> reducirStock(
            @PathVariable UUID id,
            @RequestBody ReducirStockRequest request) {
        try {
            Producto producto = productoService.reducirStock(id, request.cantidad());
            return ResponseEntity.ok(producto);
        } catch (ProductoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        } catch (StockInsuficienteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public record ProductoRequest(
            String nombre,
            String descripcion,
            BigDecimal precio,
            int stockInicial
    ) {}

    public record ActualizarStockRequest(int cantidad) {}
    public record ReducirStockRequest(int cantidad) {}
}

// === ARCHIVO: src/main/java/com/gestionpedidos/application/service/PedidoService.java ===
package com.gestionpedidos.application.service;

import com.gestionpedidos.domain.exception.PedidoNoEncontradoException;
import com.gestionpedidos.domain.exception.ProductoNoEncontradoException;
import com.gestionpedidos.domain.exception.StockInsuficienteException;
import com.gestionpedidos.domain.model.Pedido;
import com.gestionpedidos.domain.model.Producto;
import com.gestionpedidos.domain.repository.PedidoRepository;
import com.gestionpedidos.domain.repository.ProductoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final PedidoFactory pedidoFactory;
    private final Map<String, PedidoState> estadosPedido;

    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
        this.pedidoFactory = new PedidoFactory();
        this.estadosPedido = inicializarEstados();
    }

    private Map<String, PedidoState> inicializarEstados() {
        Map<String, PedidoState> estados = new ConcurrentHashMap<>();
        estados.put("PENDIENTE", new PedidoState("PENDIENTE", true, false));
        estados.put("CONFIRMADO", new PedidoState("CONFIRMADO", true, false));
        estados.put("EN_PREPARACION", new PedidoState("EN_PREPARACION", true, false));
        estados.put("ENVIADO", new PedidoState("ENVIADO", true, false));
        estados.put("ENTREGADO", new PedidoState("ENTREGADO", false, true));
        estados.put("CANCELADO", new PedidoState("CANCELADO", false, true));
        return estados;
    }

    public Pedido crearPedido(List<ProductoCantidad> productos, UUID clienteId) {
        validarProductos(productos);
        
        Pedido pedido = pedidoFactory.crearPedido(clienteId);
        
        for (ProductoCantidad pc : productos) {
            Producto producto = productoRepository.findById(pc.productoId())
                    .orElseThrow(() -> new ProductoNoEncontradoException(
                            "Producto no encontrado: " + pc.productoId()));
            
            if (producto.getStock() < pc.cantidad()) {
                throw new StockInsuficienteException(
                        "Stock insuficiente para producto: " + producto.getNombre() +
                        ". Stock actual: " + producto.getStock() +
                        ", solicitado: " + pc.cantidad());
            }
            
            producto.reducirStock(pc.cantidad());
            productoRepository.save(producto);
            pedido.agregarProducto(producto, pc.cantidad());
        }
        
        return pedidoRepository.save(pedido);
    }

    private void validarProductos(List<ProductoCantidad> productos) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("La lista de productos no puede estar vacía");
        }
        for (ProductoCantidad pc : productos) {
            if (pc.productoId() == null) {
                throw new IllegalArgumentException("El ID del producto no puede ser nulo");
            }
            if (pc.cantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
            }
        }
    }

    public Optional<Pedido> buscarPorId(UUID id) {
        if (id == null) {
            return Optional.empty();
        }
        return pedidoRepository.findById(id);
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> buscarPorEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
        }
        return pedidoRepository.findByEstado(estado.toUpperCase());
    }

    public Pedido actualizarEstado(UUID id, String nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNoEncontradoException("Pedido no encontrado: " + id));
        
        String estadoUpper = nuevoEstado.toUpperCase();
        PedidoState estado = estadosPedido.get(estadoUpper);
        
        if (estado == null) {
            throw new IllegalArgumentException("Estado de pedido inválido: " + nuevoEstado);
        }
        
        String estadoActual = pedido.getEstado();
        PedidoState estadoActualObj = estadosPedido.get(estadoActual);
        
        if (!estadoActualObj.puedeTransicionar()) {
            throw new IllegalStateException(
                    "No se puede cambiar el estado de un pedido " + estadoActual);
        }
        
        if (estado.esFinal() && !esTransicionValida(estadoActual, estadoUpper)) {
            throw new IllegalStateException(
                    "Transición inválida de " + estadoActual + " a " + estadoUpper);
        }
        
        pedido.actualizarEstado(estadoUpper);
        return pedidoRepository.save(pedido);
    }

    private boolean esTransicionValida(String desde, String hacia) {
        if ("CANCELADO".equals(desde)) {
            return false;
        }
        if ("ENTREGADO".equals(desde)) {
            return false;
        }
        return true;
    }

    public Pedido agregarProducto(UUID pedidoId, UUID productoId, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNoEncontradoException("Pedido no encontrado: " + pedidoId));
        
        if ("CANCELADO".equals(pedido.getEstado()) || "ENTREGADO".equals(pedido.getEstado())) {
            throw new IllegalStateException(
                    "No se pueden agregar productos a un pedido en estado: " + pedido.getEstado());
        }
        
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado: " + productoId));
        
        if (producto.getStock() < cantidad) {
            throw new StockInsuficienteException(
                    "Stock insuficiente. Disponible: " + producto.getStock() + ", solicitado: " + cantidad);
        }
        
        producto.reducirStock(cantidad);
        productoRepository.save(producto);
        pedido.agregarProducto(producto, cantidad);
        
        return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(UUID id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNoEncontradoException("Pedido no encontrado: " + id));
        
        if ("ENVIADO".equals(pedido.getEstado()) || "ENTREGADO".equals(pedido.getEstado())) {
            throw new IllegalStateException(
                    "No se puede eliminar un pedido en estado: " + pedido.getEstado());
        }
        
        restaurarStockProductos(pedido);
        pedidoRepository.deleteById(id);
    }

    private void restaurarStockProductos(Pedido pedido) {
        pedido.getProductos().forEach(pp -> {
            productoRepository.findById(pp.getProducto().getId()).ifPresent(producto -> {
                producto.aumentarStock(pp.getCantidad());
                productoRepository.save(producto);
            });
        });
    }

    public BigDecimal calcularTotal(UUID pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNoEncontradoException("Pedido no encontrado: " + pedidoId));
        return pedido.getTotal();
    }

    public record ProductoCantidad(UUID productoId, int cantidad) {}

    private static class PedidoState {
        private final String nombre;
        private final boolean puedeTransicionar;
        private final boolean esFinal;

        public PedidoState(String nombre, boolean puedeTransicionar, boolean esFinal) {
            this.nombre = nombre;
            this.puedeTransicionar = puedeTransicionar;
            this.esFinal = esFinal;
        }

        public boolean puedeTransicionar() {
            return puedeTransicionar;
        }

        public boolean esFinal() {
            return esFinal;
        }
    }

    private static class PedidoFactory {
        public Pedido crearPedido(UUID clienteId) {
            Pedido pedido = new Pedido();
            return pedido;
        }
    }
}

// === ARCHIVO: src/main/java/com/gestionpedidos/application/service/ProductoService.java ===
package com.gestionpedidos.application.service;

import com.gestionpedidos.domain.model.Producto;
import com.gestionpedidos.domain.repository.ProductoRepository;
import com.gestionpedidos.domain.exception.ProductoNoEncontradoException;
import com.gestionpedidos.domain.exception.StockInsuficienteException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto crearProducto(String nombre, String descripcion, BigDecimal precio, int stock) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (precio == null || precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        Producto producto = new Producto();
        producto.setId(UUID.randomUUID());
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);

        return productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public Producto obtenerProductoPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del producto no puede ser nulo");
        }
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Producto> listarTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Producto> buscarProductosPorNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return List.of();
        }
        return productoRepository.findByNombreContaining(nombre);
    }

    public Producto actualizarProducto(UUID id, String nombre, String descripcion, BigDecimal precio, Integer stock) {
        Producto productoExistente = obtenerProductoPorId(id);

        if (nombre != null && !nombre.isBlank()) {
            productoExistente.setNombre(nombre);
        }
        if (descripcion != null) {
            productoExistente.setDescripcion(descripcion);
        }
        if (precio != null && precio.compareTo(BigDecimal.ZERO) > 0) {
            productoExistente.setPrecio(precio);
        }
        if (stock != null && stock >= 0) {
            productoExistente.setStock(stock);
        }

        return productoRepository.save(productoExistente);
    }

    public void eliminarProducto(UUID id) {
        Producto producto = obtenerProductoPorId(id);
        productoRepository.deleteById(producto.getId());
    }

    public void reducirStock(UUID id, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a reducir debe ser mayor que cero");
        }
        Producto producto = obtenerProductoPorId(id);
        producto.reducirStock(cantidad);
        productoRepository.save(producto);
    }

    public void aumentarStock(UUID id, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a aumentar debe ser mayor que cero");
        }
        Producto producto = obtenerProductoPorId(id);
        producto.aumentarStock(cantidad);
        productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public boolean verificarDisponibilidad(UUID productoId, int cantidadRequerida) {
        Producto producto = obtenerProductoPorId(productoId);
        return producto.getStock() >= cantidadRequerida;
    }

    public void validarStockSuficiente(UUID productoId, int cantidadRequerida) {
        if (!verificarDisponibilidad(productoId, cantidadRequerida)) {
            Producto producto = obtenerProductoPorId(productoId);
            throw new StockInsuficienteException(
                String.format("Stock insuficiente para el producto '%s'. Disponible: %d, requerido: %d",
                    producto.getNombre(), producto.getStock(), cantidadRequerida)
            );
        }
    }
}

// === ARCHIVO: src/main/java/com/gestionpedidos/infrastructure/config/GlobalExceptionHandler.java ===
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

// === ARCHIVO: src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java ===
package com.gestionpedidos.interfaces.rest;

import com.gestionpedidos.application.service.PedidoService;
import com.gestionpedidos.domain.model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para PedidoController")
class PedidoControllerTest {

    @Mock
    private PedidoService pedidoService;

    @InjectMocks
    private PedidoController pedidoController;

    private MockMvc mockMvc;
    private Pedido pedidoPrueba;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pedidoController).build();
        pedidoPrueba = new Pedido();
        pedidoPrueba.setId(UUID.randomUUID());
        pedidoPrueba.setFechaCreacion(LocalDateTime.now());
        pedidoPrueba.setFechaActualizacion(LocalDateTime.now());
        pedidoPrueba.setEstado("PENDIENTE");
        pedidoPrueba.setTotal(new BigDecimal("150.00"));
    }

    @Test
    @DisplayName("Crear pedido - Caso de éxito")
    void testCrearPedido_CasoExito() {
        // Given: un pedido válido para crear
        // When: el servicio crea el pedido exitosamente
        // Then: retorna código 201 Created con el pedido
    }

    @Test
    @DisplayName("Crear pedido - Validación de datos obligatorios")
    void testCrearPedido_ValidacionDatos() {
        // Given: un pedido con datos inválidos
        // When: se intenta crear el pedido
        // Then: retorna código 400 Bad Request
    }

    @Test
    @DisplayName("Obtener pedido por ID - Caso de éxito")
    void testObtenerPedidoPorId_CasoExito() {
        // Given: un ID de pedido existente
        // When: el servicio busca el pedido
        // Then: retorna el pedido con código 200 OK
    }

    @Test
    @DisplayName("Obtener pedido por ID - No encontrado")
    void testObtenerPedidoPorId_NoEncontrado() {
        // Given: un ID de pedido que no existe
        // When: el servicio intenta buscarlo
        // Then: retorna código 404 Not Found
    }

    @Test
    @DisplayName("Listar todos los pedidos - Caso de éxito")
    void testListarPedidos_CasoExito() {
        // Given: pedidos existentes en la base de datos
        // When: se solicitan todos los pedidos
        // Then: retorna lista con código 200 OK
    }

    @Test
    @DisplayName("Actualizar estado del pedido - Caso de éxito")
    void testActualizarEstado_CasoExito() {
        // Given: un pedido existente y nuevo estado
        // When: el servicio actualiza el estado
        // Then: retorna código 200 OK con el pedido actualizado
    }

    @Test
    @DisplayName("Actualizar estado - Transición inválida")
    void testActualizarEstado_TransicionInvalida() {
        // Given: un pedido con estado que no permite transición
        // When: se intenta actualizar a un estado inválido
        // Then: retorna código 400 Bad Request
    }

    @Test
    @DisplayName("Eliminar pedido - Caso de éxito")
    void testEliminarPedido_CasoExito() {
        // Given: un ID de pedido existente
        // When: el servicio elimina el pedido
        // Then: retorna código 204 No Content
    }

    @Test
    @DisplayName("Eliminar pedido - No encontrado")
    void testEliminarPedido_NoEncontrado() {
        // Given: un ID de pedido que no existe
        // When: se intenta eliminar
        // Then: retorna código 404 Not Found
    }

    @Test
    @DisplayName("Buscar pedidos por estado - Caso de éxito")
    void testBuscarPorEstado_CasoExito() {
        // Given: un estado específico
        // When: el servicio busca pedidos por estado
        // Then: retorna lista de pedidos con código 200 OK
    }
}

// === ARCHIVO: src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java ===
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

// === ARCHIVO: RunCucumberTest.java ===
import io.cucumber.junit.platform.Cucumber;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.gestionpedidos")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber-report.html")
public class RunCucumberTest {
}

// === ARCHIVO: src/test/java/com/gestionpedidos/XSteps.java ===
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
```
