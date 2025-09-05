package com.example.demo.Servicios.Ticket

import com.example.demo.Modelos.Ticket.Ticket
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class TicketService(private val jdbcTemplate: JdbcTemplate) {

    fun obtenerTickets(): List<String> {
        val sql = "SELECT id, usuario_id, tipo_solicitud_id, titulo, descripcion, estado_ticket_id, creado_en, actualizado_en FROM tickets"
        return jdbcTemplate.query(sql, RowMapper<String> { rs, _ ->
            "id: ${rs.getInt("id")} - Título: ${rs.getString("titulo")} - Descripción: ${rs.getString("descripcion")} - UsuarioID: ${rs.getInt("usuario_id")} - TipoSolicitudID: ${rs.getInt("tipo_solicitud_id")} - EstadoTicketID: ${rs.getInt("estado_ticket_id")} - CreadoEn: ${rs.getString("creado_en")} - ActualizadoEn: ${rs.getString("actualizado_en")}"
        })
    }

    fun crearTicket(ticket: Ticket) {
        val sql = """
            INSERT INTO tickets (usuario_id, tipo_solicitud_id, titulo, descripcion, estado_ticket_id) 
            VALUES (?, ?, ?, ?, ?)
        """
        jdbcTemplate.update(sql, ticket.usuario_id, ticket.tipo_solicitud_id, ticket.titulo, ticket.descripcion, ticket.estado_ticket_id)
    }

    fun eliminarTicket(id: Int) {
        val sql = "DELETE FROM tickets WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    fun editarTicket(id: Int, ticket: Ticket) {
        val sql = """
            UPDATE tickets 
            SET usuario_id = ?, tipo_solicitud_id = ?, titulo = ?, descripcion = ?, estado_ticket_id = ? 
            WHERE id = ?
        """
        jdbcTemplate.update(sql, ticket.usuario_id, ticket.tipo_solicitud_id, ticket.titulo, ticket.descripcion, ticket.estado_ticket_id, id)
    }
}