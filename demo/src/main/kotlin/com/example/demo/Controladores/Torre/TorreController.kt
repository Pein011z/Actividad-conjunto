package com.example.demo.Controller.Torre

import com.example.demo.Modelos.Torre.Torre
import com.example.demo.Servicios.Torre.TorreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class TorreController(@Autowired val torreService: TorreService) {

    @GetMapping("/torres")
    fun obtenerTorre(): List<String> {
        return torreService.obtenerTorre()
    }

    @PostMapping("/torres")
    fun crearTorre(@RequestBody torre: Torre): String {
        torreService.crearTorre(torre)
        return "Torre creada correctamente"
    }

    @DeleteMapping("/torres/{id}")
    fun eliminarTorre(@PathVariable id: Int): String {
        torreService.eliminarTorre(id)
        return "Torre eliminada correctamente"
    }

    @PutMapping("/torres/{id}")
    fun editarTorre(@PathVariable id: Int, @RequestBody torre: Torre): String {
        torreService.actualizarTorre(id, torre)
        return "Torre actualizada correctamente"
    }
}