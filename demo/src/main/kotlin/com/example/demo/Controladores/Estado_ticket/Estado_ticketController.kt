package com.example.demo.Controladores.EstadoTicket

import com.example.demo.Modelos.EstadoTicket.EstadoTicket
import com.example.demo.Servicios.EstadoTicket.EstadoTicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/estados-ticket")
class EstadoTicketController(@Autowired val estadoTicketService: EstadoTicketService) {

    @GetMapping
    fun obtenerEstadosTicket(): List<String> {
        return estadoTicketService.obtenerEstadosTicket()
    }

    @PostMapping
    fun crearEstadoTicket(@RequestBody estadoTicket: EstadoTicket): String {
        estadoTicketService.crearEstadoTicket(estadoTicket)
        return "Estado de ticket creado correctamente"
    }

    @DeleteMapping("/{id}")
    fun eliminarEstadoTicket(@PathVariable id: Int): String {
        estadoTicketService.eliminarEstadoTicket(id)
        return "Estado de ticket eliminado correctamente"
    }

    @PutMapping("/{id}")
    fun actualizarEstadoTicket(@PathVariable id: Int, @RequestBody estadoTicket: EstadoTicket): String {
        estadoTicketService.actualizarEstadoTicket(id, estadoTicket)
        return "Estado de ticket actualizado correctamente"
    }
}