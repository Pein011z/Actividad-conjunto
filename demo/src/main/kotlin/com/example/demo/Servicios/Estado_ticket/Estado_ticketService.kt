package com.example.demo.Servicios.EstadoTicket

import com.example.demo.Modelos.EstadoTicket.EstadoTicket
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class EstadoTicketService(private val jdbcTemplate: JdbcTemplate) {

    fun obtenerEstadosTicket(): List<String> {
        val sql = "SELECT id, nombre, creado_en, actualizado_en FROM estado_ticket"
        return jdbcTemplate.query(sql, RowMapper<String> { rs, _ ->
            "id: ${rs.getInt("id")} - Nombre: ${rs.getString("nombre")} - CreadoEn: ${rs.getString("creado_en")} - ActualizadoEn: ${rs.getString("actualizado_en")}"
        })
    }

    fun crearEstadoTicket(estadoTicket: EstadoTicket) {
        val sql = """
            INSERT INTO estado_ticket (nombre) 
            VALUES (?)
        """
        jdbcTemplate.update(sql, estadoTicket.nombre)
    }

    fun eliminarEstadoTicket(id: Int) {
        val sql = "DELETE FROM estado_ticket WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    fun actualizarEstadoTicket(id: Int, estadoTicket: EstadoTicket) {
        val sql = "UPDATE estado_ticket SET nombre = ? WHERE id = ?"
        jdbcTemplate.update(sql, estadoTicket.nombre, id)
    }
}