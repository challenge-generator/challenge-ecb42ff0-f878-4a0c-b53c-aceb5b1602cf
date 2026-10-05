# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Desarrollo de un sistema de gestión de pedidos utilizando POO avanzada**.

| | |
|---|---|
| Tema | Implementación de programación orientada a objetos (POO) - avanzado |
| Nivel | senior-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / Spring Boot 3.3 |
| Patron arquitectonico | capas estándar con separación de dominio (DDD ligero) |
| Tiempo estimado | 10 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.3.0
- org.springframework.boot:spring-boot-starter-data-jpa 3.3.0
- com.h2database:h2 2.2.224
- org.springframework.boot:spring-boot-starter-test 3.3.0
- org.assertj:assertj-core 3.25.3
- org.projectlombok:lombok 1.18.30

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean test-compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean test-compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Modelado de entidades y relaciones**: Diagrama de clases y relaciones, y las definiciones de clases en código.
- **Fase 2 — Conexión a la base de datos**: Código que establece la conexión a la base de datos y métodos CRUD para pedidos y productos.
- **Fase 3 — Implementación de patrones de diseño**: Código que implementa los patrones de diseño seleccionados.
- **Fase 4 — Realización de pruebas unitarias**: Código de pruebas unitarias y resultados de ejecución.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `RunCucumberTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Archivos que la arquitectura declara (1 de 20)

La propuesta arquitectonica del reto los lista y no llegaron al repo. Crealos con implementacion real, respetando la capa en la que viven:

- [ ] `XSteps.java`

### 2. Referencias colgando (95)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `RunCucumberTest.java` — `io.cucumber.junit`
      El import io.cucumber.junit.platform.Cucumber pertenece a io.cucumber.junit, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `io.cucumber.java`
      El import io.cucumber.java.es.Cuando pertenece a io.cucumber.java, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/gestionpedidos/domain/model/Pedido.java` — `Producto.getPrecio`
      Se invoca `getPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java` — `Pedido.getId`
      Se invoca `getId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java` — `Pedido.setFechaCreacion`
      Se invoca `setFechaCreacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java` — `Pedido.setFechaActualizacion`
      Se invoca `setFechaActualizacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java` — `Pedido.getEstado`
      Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.productos`
      Se invoca `productos` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.clienteId`
      Se invoca `clienteId` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.nuevoEstado`
      Se invoca `nuevoEstado` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.productoId`
      Se invoca `productoId` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `AgregarProductoRequest.cantidad`
      Se invoca `cantidad` sobre `AgregarProductoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java` — `Pedido.getTotal`
      Se invoca `getTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.obtenerTodosLosProductos`
      Se invoca `obtenerTodosLosProductos` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.buscarPorId`
      Se invoca `buscarPorId` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.buscarPorNombre`
      Se invoca `buscarPorNombre` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.obtenerProductosConStockBajo`
      Se invoca `obtenerProductosConStockBajo` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.nombre`
      Se invoca `nombre` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.descripcion`
      Se invoca `descripcion` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.precio`
      Se invoca `precio` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.stockInicial`
      Se invoca `stockInicial` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ProductoService.actualizarStock`
      Se invoca `actualizarStock` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java` — `ReducirStockRequest.cantidad`
      Se invoca `cantidad` sobre `ReducirStockRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Producto.getStock`
      Se invoca `getStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Producto.getNombre`
      Se invoca `getNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `PedidoState.isBlank`
      Se invoca `isBlank` sobre `PedidoState`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `PedidoState.toUpperCase`
      Se invoca `toUpperCase` sobre `PedidoState`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Pedido.getEstado`
      Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `PedidoState.puedeTransicionar`
      Se invoca `puedeTransicionar` sobre `PedidoState`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `PedidoState.esFinal`
      Se invoca `esFinal` sobre `PedidoState`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Pedido.getProductos`
      Se invoca `getProductos` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/PedidoService.java` — `Pedido.getTotal`
      Se invoca `getTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setId`
      Se invoca `setId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setNombre`
      Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setDescripcion`
      Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setPrecio`
      Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.setStock`
      Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.getId`
      Se invoca `getId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.getStock`
      Se invoca `getStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/gestionpedidos/application/service/ProductoService.java` — `Producto.getNombre`
      Se invoca `getNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setId`
      Se invoca `setId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setFechaCreacion`
      Se invoca `setFechaCreacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setFechaActualizacion`
      Se invoca `setFechaActualizacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setEstado`
      Se invoca `setEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java` — `Pedido.setTotal`
      Se invoca `setTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setId`
      Se invoca `setId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setFechaCreacion`
      Se invoca `setFechaCreacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setFechaActualizacion`
      Se invoca `setFechaActualizacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setEstado`
      Se invoca `setEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.setTotal`
      Se invoca `setTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setId`
      Se invoca `setId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setNombre`
      Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setDescripcion`
      Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setPrecio`
      Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Producto.setStock`
      Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.getId`
      Se invoca `getId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.get`
      Se invoca `get` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `PedidoService.listarTodos`
      Se invoca `listarTodos` sobre `PedidoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `Pedido.getEstado`
      Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java` — `PedidoService.eliminar`
      Se invoca `eliminar` sobre `PedidoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setId`
      Se invoca `setId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setNombre`
      Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setDescripcion`
      Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setPrecio`
      Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.setStock`
      Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.crear`
      Se invoca `crear` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.getNombre`
      Se invoca `getNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.buscarPorId`
      Se invoca `buscarPorId` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.getId`
      Se invoca `getId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.get`
      Se invoca `get` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.listarTodos`
      Se invoca `listarTodos` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.actualizar`
      Se invoca `actualizar` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `ProductoService.eliminar`
      Se invoca `eliminar` sobre `ProductoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java` — `Producto.getStock`
      Se invoca `getStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `PedidoJpaRepository.deleteAll`
      Se invoca `deleteAll` sobre `PedidoJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setId`
      Se invoca `setId` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setNombre`
      Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setDescripcion`
      Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setPrecio`
      Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Producto.setStock`
      Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setId`
      Se invoca `setId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setFechaCreacion`
      Se invoca `setFechaCreacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setFechaActualizacion`
      Se invoca `setFechaActualizacion` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setEstado`
      Se invoca `setEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.setTotal`
      Se invoca `setTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.getId`
      Se invoca `getId` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java` — `Pedido.getEstado`
      Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.setNombre`
      Se invoca `setNombre` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.setPrecio`
      Se invoca `setPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.setStock`
      Se invoca `setStock` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.setDescripcion`
      Se invoca `setDescripcion` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `Pedido.setTotal`
      Se invoca `setTotal` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `Producto.getPrecio`
      Se invoca `getPrecio` sobre `Producto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `Pedido.setEstado`
      Se invoca `setEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/gestionpedidos/XSteps.java` — `Pedido.getEstado`
      Se invoca `getEstado` sobre `Pedido`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (23)

- `pom.xml`
- `src/main/java/com/gestionpedidos/GestionPedidosApplication.java`
- `src/main/resources/application.properties`
- `src/main/java/com/gestionpedidos/domain/model/Pedido.java`
- `src/main/java/com/gestionpedidos/domain/model/Producto.java`
- `src/main/java/com/gestionpedidos/domain/repository/PedidoRepository.java`
- `src/main/java/com/gestionpedidos/domain/repository/ProductoRepository.java`
- `src/main/java/com/gestionpedidos/domain/exception/StockInsuficienteException.java`
- `src/main/java/com/gestionpedidos/domain/exception/PedidoNoEncontradoException.java`
- `src/main/java/com/gestionpedidos/domain/exception/ProductoNoEncontradoException.java`
- `src/main/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepository.java`
- `src/main/java/com/gestionpedidos/infrastructure/persistence/ProductoJpaRepository.java`
- `src/main/java/com/gestionpedidos/interfaces/rest/PedidoController.java`
- `src/main/java/com/gestionpedidos/interfaces/rest/ProductoController.java`
- `src/main/java/com/gestionpedidos/application/service/PedidoService.java`
- `src/main/java/com/gestionpedidos/application/service/ProductoService.java`
- `src/main/java/com/gestionpedidos/infrastructure/config/GlobalExceptionHandler.java`
- `src/test/java/com/gestionpedidos/interfaces/rest/PedidoControllerTest.java`
- `src/test/java/com/gestionpedidos/application/service/PedidoServiceTest.java`
- `src/test/java/com/gestionpedidos/application/service/ProductoServiceTest.java`
- `src/test/java/com/gestionpedidos/infrastructure/persistence/PedidoJpaRepositoryTest.java`
- `RunCucumberTest.java`
- `src/test/java/com/gestionpedidos/XSteps.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/gestionpedidos`
- `src/main/java/com/gestionpedidos/domain`
- `src/main/java/com/gestionpedidos/application`
- `src/main/java/com/gestionpedidos/infrastructure`
- `src/main/java/com/gestionpedidos/interfaces`
- `src/main/resources`
- `src/test/java/com/gestionpedidos`

## Verificacion

```bash
mvn clean test-compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar con separación de dominio (DDD ligero)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatizador, Seniority Senior
- Brecha que el reto ataca: Demuestra un dominio avanzado en al menos uno (1) de los siguientes lenguajes de Programación Orientada a Objetos: Java, Python, dart, JavaScript, TypeScript., en temas clave como: conexiones a base de datos, manejo de excepciones, interfaces, clases abstractas, colecciones, uso de bibliotecas/frameworks, patrones de diseño orientados a objetos, herramientas de pruebas unitarias
- Mision: Candidato Senior en Calidad de Software con experiencia en automatización

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
