package com.example.demo.Controller.Ticket

import com.example.demo.Modelos.Ticket.Ticket
import com.example.demo.Servicios.Ticket.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class TicketController(@Autowired val ticketService: TicketService) {

    @GetMapping("/tickets")
    fun obtenerTickets(): List<String> {
        return ticketService.obtenerTickets()
    }

    @PostMapping("/tickets")
    fun crearTicket(@RequestBody ticket: Ticket): String {
        ticketService.crearTicket(ticket)
        return "Ticket creado correctamente"
    }

    @DeleteMapping("/tickets/{id}")
    fun eliminarTicket(@PathVariable id: Int): String {
        ticketService.eliminarTicket(id)
        return "Ticket eliminado correctamente"
    }

    @PutMapping("/tickets/{id}")
    fun editarTicket(@PathVariable id: Int, @RequestBody ticket: Ticket): String {
        ticketService.editarTicket(id, ticket)
        return "Ticket actualizado correctamente"
    }
}