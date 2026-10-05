# Desarrollo de un sistema de gestión de pedidos utilizando POO avanzada

El sistema de gestión de pedidos para una tienda en línea debe manejar la creación, actualización y eliminación de pedidos. Los pedidos tienen productos asociados, y cada producto tiene un precio y stock. El sistema debe conectarse a una base de datos para almacenar y recuperar información de pedidos y productos. Debe manejar excepciones de manera adecuada y utilizar interfaces, clases abstractas y colecciones. Además, se deben implementar patrones de diseño orientados a objetos y realizar pruebas unitarias.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Implementación de programación orientada a objetos (POO) - avanzado |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 10 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Modelado de entidades y relaciones

**Objetivo:** Definir las clases y relaciones necesarias para representar pedidos y productos en el sistema.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar las entidades principales (pedidos y productos) y sus atributos.
- Definir las relaciones entre las entidades (un pedido puede tener múltiples productos).
- Crear las clases necesarias utilizando POO avanzada (interfaces, clases abstractas).

**Entregable:** Diagrama de clases y relaciones, y las definiciones de clases en código.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo las interfaces pueden ser utilizadas para definir contratos.
- Piensa en cómo las clases abstractas pueden ser usadas para proporcionar implementaciones parciales.

</details>

### Fase 2: Conexión a la base de datos

**Objetivo:** Implementar la conexión a la base de datos para almacenar y recuperar información de pedidos y productos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Establecer una conexión a la base de datos utilizando un ORM (Object-Relational Mapping).
- Definir los métodos necesarios para crear, leer, actualizar y eliminar pedidos y productos.
- Manejar excepciones de conexión y operaciones de base de datos.

**Entregable:** Código que establece la conexión a la base de datos y métodos CRUD para pedidos y productos.

<details>
<summary>Pistas de conocimiento</summary>

- Investiga sobre ORMs y cómo pueden simplificar la interacción con la base de datos.
- Considera cómo manejarías excepciones de conexión y operaciones.

</details>

### Fase 3: Implementación de patrones de diseño

**Objetivo:** Aplicar patrones de diseño orientados a objetos para mejorar la estructura y mantenibilidad del código.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identificar patrones de diseño adecuados para el sistema (ej. Factory, Singleton, Observer).
- Implementar los patrones de diseño seleccionados en el código.
- Evaluar la mejora en la estructura y mantenibilidad del código.

**Entregable:** Código que implementa los patrones de diseño seleccionados.

<details>
<summary>Pistas de conocimiento</summary>

- Investiga sobre diferentes patrones de diseño y sus aplicaciones.
- Considera cómo los patrones de diseño pueden mejorar la estructura y mantenibilidad del código.

</details>

### Fase 4: Realización de pruebas unitarias

**Objetivo:** Escribir y ejecutar pruebas unitarias para verificar el funcionamiento correcto del sistema.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Escribir pruebas unitarias para los métodos CRUD de pedidos y productos.
- Ejecutar las pruebas y verificar el funcionamiento correcto del sistema.
- Identificar y corregir errores encontrados durante las pruebas.

**Entregable:** Código de pruebas unitarias y resultados de ejecución.

<details>
<summary>Pistas de conocimiento</summary>

- Investiga sobre frameworks de pruebas unitarias y sus características.
- Considera cómo escribirías pruebas efectivas para verificar el funcionamiento correcto del sistema.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los patrones de diseño y cómo se aplican en POO?
- **paraQueSirve**: ¿Para qué sirven las interfaces y clases abstractas en POO?
- **comoSeUsa**: ¿Cómo se utiliza un ORM para interactuar con una base de datos en POO?
- **erroresComunes**: ¿Cuáles son los errores comunes al manejar excepciones en POO?
- **queDecisionesImplica**: ¿Qué decisiones implica la elección de un patrón de diseño en POO?

## Criterios de Evaluacion

- Modelado correcto de entidades y relaciones utilizando POO avanzada.
- Implementación exitosa de la conexión a la base de datos y métodos CRUD.
- Aplicación efectiva de patrones de diseño orientados a objetos.
- Escritura y ejecución de pruebas unitarias para verificar el funcionamiento correcto del sistema.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean test-compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
