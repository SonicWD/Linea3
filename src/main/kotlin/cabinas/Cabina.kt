package cabinas

data class Cabina(
    val id: Int
) {
    // Lista para guardar las llamadas
    private var llamadas: MutableList<Llamada> = mutableListOf()

    // Función para registrar la llamada
    fun registrarLlamada(tipo: TipoLlamada, duracion: Int) {
        llamadas.add(Llamada(tipo, duracion))
    }

    // Función para obtener el número de llamadas
    fun obtenerNumeroLlamadas(): Int = llamadas.size

    // Función para obtener la duración total de las llamadas
    fun obtenerDuracionTotal(): Int = llamadas.sumOf { it.duracion }

    // Función para obtener el costo total de las llamadas
    fun obtenerCostoTotal(): Int = llamadas.sumOf { it.calcularCosto() }

    // Función para obtener el detalle de la cabina
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

    // Función para reiniciar la cabina
    fun reiniciarCabina() {
        llamadas.clear()
    }
}
