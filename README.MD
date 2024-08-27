# Sistema de Gestión de Cabinas Telefónicas - Simulador en Kotlin

## Descripción
Este proyecto simula un sistema para gestionar múltiples cabinas telefónicas. Permite registrar llamadas, calcular costos y generar reportes detallados. Es una excelente práctica para consolidar conocimientos en programación orientada a objetos en Kotlin.

## Objetivos
* **Aprendizaje:** Aplicar conceptos de POO en Kotlin.
* **Desarrollo:** Crear una aplicación funcional y escalable.
* **Práctica:** Consolidar conocimientos en diseño de clases y algoritmos.

## Diagrama de Clases
[Image of class diagram]

*Puedes reemplazar "[Image of class diagram]" con la URL de tu diagrama, o incrustarla directamente si estás usando GitHub Pages.*

## Características Principales
* **Registro de llamadas:** Permite registrar llamadas de diferentes tipos (local, larga distancia, celular) con su duración.
* **Cálculo de costos:** Calcula el costo total de cada llamada y de todas las llamadas realizadas.
* **Generación de reportes:** Genera reportes detallados por cabina y un reporte consolidado de todas las cabinas.
* **Reinicio de cabinas:** Permite reiniciar una o todas las cabinas para borrar los registros de llamadas.

## Tecnologías Utilizadas
* **Lenguaje:** Kotlin
* **IDE:** IntelliJ IDEA (recomendado)
* **Control de versiones:** Git

## Clases Principales

### Cabina

Representa una cabina telefónica que puede registrar llamadas.

**Métodos principales:**
- `registrarLlamada(tipo: TipoLlamada, duracion: Int)`: Registra una llamada con un tipo y duración especificados.
- `obtenerNumeroLlamadas()`: Devuelve el número total de llamadas registradas.
- `obtenerDuracionTotal()`: Devuelve la duración total de todas las llamadas en minutos.
- `obtenerCostoTotal()`: Devuelve el costo total de todas las llamadas registradas.
- `reiniciarCabina()`: Borra todas las llamadas registradas en la cabina.

### Llamada

Representa una llamada telefónica registrada en una cabina.

**Propiedades:**
- `tipo`: Tipo de llamada (local, larga distancia, celular).
- `duracion`: Duración de la llamada en minutos.

**Métodos principales:**
- `calcularCosto()`: Calcula el costo de la llamada basado en su tipo y duración.

### TipoLlamada

Enum que define los tipos posibles de llamadas:
- `LOCAL`
- `LARGA_DISTANCIA`
- `CELULAR`

### Empresa

Maneja un conjunto de cabinas telefónicas.

**Métodos principales:**
- `agregarCabina(cabina: Cabina)`: Agrega una nueva cabina a la empresa.
- `mostrarConsolidado()`: Devuelve un resumen de todas las llamadas en todas las cabinas.
- `reiniciarTodasLasCabinas()`: Borra los registros de llamadas de todas las cabinas.

## Ejecución del Programa

El programa permite al usuario interactuar a través de la consola para:
- Seleccionar una cabina para registrar una llamada.
- Elegir el tipo de llamada (local, larga distancia, celular).
- Registrar una llamada con una duración aleatoria entre 1 y 120 minutos.
- Mostrar un resumen final con el detalle de cada cabina y un consolidado de todas las llamadas.

## Instalación y Ejecución

1. Clona el repositorio:

    ```bash
    git clone https://github.com/SonicWD/Linea3.git
    ```

2. Navega al directorio del proyecto:

    ```bash
    cd Linea3
    ```

3. Asegúrate de tener Kotlin instalado y configurado en tu entorno de desarrollo. Puedes usar un IDE como IntelliJ IDEA para abrir el proyecto.

4. Ejecuta el programa desde el IDE o usando la línea de comandos:

    ```bash
    kotlinc -include-runtime -d app.jar src/**/*.kt
    java -jar app.jar
    ```
## Pruebas

Para garantizar la funcionalidad del proyecto, se han implementado pruebas unitarias. Estas pruebas están diseñadas para verificar el comportamiento de las clases y métodos principales.

**Pruebas realizadas:**
- **Cabina**: Se prueban métodos como `registrarLlamada`, `obtenerNumeroLlamadas`, `obtenerDuracionTotal`, `obtenerCostoTotal` y `reiniciarCabina`.
- **Llamada**: Se prueba el método `calcularCosto` para asegurar que el costo se calcula correctamente según el tipo de llamada y la duración.
- **Empresa**: Se prueban métodos como `agregarCabina`, `mostrarConsolidado` y `reiniciarTodasLasCabinas` para garantizar que las cabinas se gestionan correctamente y que el consolidado se calcula de forma precisa.

Para ejecutar las pruebas, utiliza el siguiente comando:

```bash
./gradlew test 
```
## Nota para el profe

Disculpa la demora en el proyecto, no sabia hacer pruebas unitarias, pero ya funciona 

