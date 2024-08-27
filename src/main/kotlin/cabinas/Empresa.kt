package cabinas

class Empresa {
    private val cabinas: MutableList<Cabina> = mutableListOf()

    fun agregarCabina(cabina: Cabina) {
        cabinas.add(cabina)
    }

    fun mostrarConsolidado(): String {
        val numeroTotalLlamadas = cabinas.sumOf { it.obtenerNumeroLlamadas() }
        val duracionTotal = cabinas.sumOf { it.obtenerDuracionTotal() }
        val costoTotal = cabinas.sumOf { it.obtenerCostoTotal() }
        val costoPromedioPorMinuto = if (duracionTotal > 0) costoTotal / duracionTotal else 0

        return """
        Consolidado total:
        Número total de llamadas: $numeroTotalLlamadas
        Duración total de llamadas: $duracionTotal minutos
        Costo total: $costoTotal pesos
        Costo promedio por minuto: $costoPromedioPorMinuto pesos/minuto
    """.trimIndent()
    }


    fun reiniciarTodasLasCabinas() {
        cabinas.forEach { it.reiniciarCabina() }
    }
}
