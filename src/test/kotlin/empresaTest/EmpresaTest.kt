package empresaTest

import cabinas.Cabina
import cabinas.Empresa
import cabinas.TipoLlamada
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EmpresaTest {

    // Declaramos las variables de la empresa y las cabinas que se usarán en las pruebas.
    private lateinit var empresa: Empresa
    private lateinit var cabina1: Cabina
    private lateinit var cabina2: Cabina

    @BeforeEach
    fun setup() {
        // Inicializamos la empresa y las cabinas antes de cada prueba.
        empresa = Empresa()
        cabina1 = Cabina(1)
        cabina2 = Cabina(2)
        // Agregamos las cabinas a la empresa.
        empresa.agregarCabina(cabina1)
        empresa.agregarCabina(cabina2)
    }

    @Test
    fun `test registrar llamada en cabina`() {
        // Registramos una llamada local de 10 minutos en la cabina1.
        cabina1.registrarLlamada(TipoLlamada.LOCAL, 10)

        // Verificamos que se haya registrado correctamente la llamada, la duración total y el costo total.
        assertEquals(1, cabina1.obtenerNumeroLlamadas())
        assertEquals(10, cabina1.obtenerDuracionTotal())
        assertEquals(500, cabina1.obtenerCostoTotal())
    }

    @Test
    fun `test obtener detalle de cabina`() {
        // Registramos una llamada de larga distancia de 5 minutos en la cabina2.
        cabina2.registrarLlamada(TipoLlamada.LARGA_DISTANCIA, 5)

        // Obtenemos el detalle de la cabina2 y verificamos que contenga la información correcta.
        val detalle = cabina2.obtenerDetalle()

        assertTrue(detalle.contains("Número de llamadas: 1"))
        assertTrue(detalle.contains("Duración total: 5 minutos"))
        assertTrue(detalle.contains("Costo total: 1750 pesos"))
    }

    @Test
    fun `test mostrar consolidado de empresa`() {
        // Registramos llamadas en cabina1 y cabina2.
        cabina1.registrarLlamada(TipoLlamada.LOCAL, 10)
        cabina2.registrarLlamada(TipoLlamada.CELULAR, 20)

        // Obtenemos el consolidado de la empresa y verificamos la información agregada.
        val consolidado = empresa.mostrarConsolidado()

        assertTrue(consolidado.contains("Número total de llamadas: 2"))
        assertTrue(consolidado.contains("Duración total de llamadas: 30 minutos"))
        assertTrue(consolidado.contains("Costo total: 3500 pesos"))
        assertTrue(consolidado.contains("Costo promedio por minuto: 116 pesos/minuto"))
    }

    @Test
    fun `test reiniciar cabina`() {
        // Registramos una llamada en la cabina1 y luego reiniciamos la cabina.
        cabina1.registrarLlamada(TipoLlamada.CELULAR, 15)
        cabina1.reiniciarCabina()

        // Verificamos que la cabina se haya reiniciado correctamente.
        assertEquals(0, cabina1.obtenerNumeroLlamadas())
        assertEquals(0, cabina1.obtenerDuracionTotal())
        assertEquals(0, cabina1.obtenerCostoTotal())
    }
}
