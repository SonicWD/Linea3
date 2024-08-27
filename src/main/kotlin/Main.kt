package com.example.telefono

import cabinas.Cabina
import cabinas.Empresa
import cabinas.TipoLlamada
import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {
    val empresa = Empresa()

    // Crear 5 cabinas predefinidas
    val cabinas = mutableListOf(
        Cabina(1), Cabina(2), Cabina(3), Cabina(4), Cabina(5)
    )
    cabinas.forEach { empresa.agregarCabina(it) }

    do {
        println("\n=====================================")
        println("    SISTEMA DE GESTIÓN DE CABINAS    ")
        println("=====================================")
        println("| Seleccione la cabina (1-5) o 0 para salir: |")
        println("=====================================")
        print(">>> ")
        val cabinaId = readLine()?.toIntOrNull() ?: 0

        if (cabinaId in 1..5) {
            val cabina = cabinas[cabinaId - 1]

            println("\n=====================================")
            println("      TIPO DE LLAMADA DISPONIBLE      ")
            println("=====================================")
            println("| 1. Local                          |")
            println("| 2. Larga Distancia                |")
            println("| 3. Celular                        |")
            println("=====================================")
            print(">>> ")

            val tipoLlamada = when (readLine()?.toIntOrNull()) {
                1 -> TipoLlamada.LOCAL
                2 -> TipoLlamada.LARGA_DISTANCIA
                3 -> TipoLlamada.CELULAR
                else -> {
                    println("Opción inválida. Seleccione un número entre 1 y 3.")
                    continue
                }
            }

            // Duración aleatoria de la llamada
            val duracion = Random.nextInt(1, 121)
            cabina.registrarLlamada(tipoLlamada, duracion)

            println("\n=====================================")
            println("     LLAMADA REGISTRADA CON ÉXITO     ")
            println("=====================================")
            println("| Tipo de Llamada: ${tipoLlamada.name}                |")
            println("| Duración: $duracion minutos                  |")
            println("=====================================")
        } else if (cabinaId == 0) {
            break
        } else {
            println("Cabina inválida. Seleccione un número entre 1 y 5.")
        }
    } while (true)

    // Mostrar resumen final
    println("\n=====================================")
    println("      RESUMEN FINAL DE LLAMADAS      ")
    println("=====================================")
    cabinas.forEach { println(it.obtenerDetalle()) }
    println(empresa.mostrarConsolidado())
    println("=====================================")

    exitProcess(0)
}
