package com.example.demo.Controladores.Torre

import com.example.demo.Modelos.Torre.Torre
import com.example.demo.Servicios.Torre.TorreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class TicketController(@Autowired val torreService: TorreService) {

    @GetMapping("/torre")
    fun obtenerTorres(): List<String> {
        return torreService.obtenerTorres()
    }

    @PostMapping("/torre")
    fun crearTorre(@RequestBody torre: Torre): String {
        torreService.crearTorre(torre)
        return "Torre creado correctamente"
    }

    @DeleteMapping("/torre/{id}")
    fun eliminarTorre(@PathVariable id: Int): String {
        torreService.eliminarTorre(id)
        return "Torre eliminado correctamente"
    }

    @PutMapping("/torre/{id}")
    fun editarTorre(@PathVariable id: Int, @RequestBody torre: Torre): String {
        torreService.editarTorre(id, torre)
        return "Torre actualizado correctamente"
    }
}