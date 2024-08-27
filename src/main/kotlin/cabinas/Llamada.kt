package cabinas

data class Llamada(
    val tipo: TipoLlamada,
    val duracion: Int
) {
    fun calcularCosto(): Int {
        return when (tipo) {
            TipoLlamada.LOCAL -> duracion * 50
            TipoLlamada.LARGA_DISTANCIA -> duracion * 350
            TipoLlamada.CELULAR -> duracion * 150
        }
    }
}
