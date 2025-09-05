package com.example.demo.Servicios.Notificacion

import com.example.demo.Modelos.Notificacion.Notificacion
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class NotificacionService(private val jdbcTemplate: JdbcTemplate) {

    fun obtenerNotificaciones(): List<String> {
        val sql = "SELECT id, usuario_id, ticket_id, fecha_envio, creado_en, actualizado_en FROM notificacion"
        return jdbcTemplate.query(sql, RowMapper<String> { rs, _ ->
            "id: ${rs.getInt("id")} - UsuarioID: ${rs.getInt("usuario_id")} - TicketID: ${rs.getInt("ticket_id")} - FechaEnvio: ${rs.getString("fecha_envio")} - CreadoEn: ${rs.getString("creado_en")} - ActualizadoEn: ${rs.getString("actualizado_en")}"
        })
    }

    fun crearNotificacion(notificacion: Notificacion) {
        val sql = """
            INSERT INTO notificacion (usuario_id, ticket_id) 
            VALUES (?, ?)
        """
        jdbcTemplate.update(sql, notificacion.usuario_id, notificacion.ticket_id)
    }

    fun eliminarNotificacion(id: Int) {
        val sql = "DELETE FROM notificacion WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    fun actualizarNotificacion(id: Int, notificacion: Notificacion) {
        val sql = """
            UPDATE notificacion 
            SET usuario_id = ?, ticket_id = ?, fecha_envio = ? 
            WHERE id = ?
        """
        jdbcTemplate.update(sql, notificacion.usuario_id, notificacion.ticket_id, notificacion.fecha_envio, id)
    }
}
