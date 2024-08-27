package cabinas

data class Cabina(val id: Int) {
    private val llamadas: MutableList<Llamada> = mutableListOf()

    fun registrarLlamada(tipo: TipoLlamada, duracion: Int) {
        llamadas.add(Llamada(tipo, duracion))
    }

    fun obtenerNumeroLlamadas(): Int = llamadas.size

    fun obtenerDuracionTotal(): Int = llamadas.sumOf { it.duracion }

    fun obtenerCostoTotal(): Int = llamadas.sumOf { it.calcularCosto() }

    fun obtenerDetalle(): String {
        val numeroLlamadas = obtenerNumeroLlamadas()
        val duracionTotal = obtenerDuracionTotal()
        val costoTotal = obtenerCostoTotal()
        return """
            Cabina $id:
            Número de llamadas: $numeroLlamadas
            Duración total: $duracionTotal minutos
            Costo total: $costoTotal pesos
        """.trimIndent()
    }

    fun reiniciarCabina() {
        llamadas.clear()
    }
}
