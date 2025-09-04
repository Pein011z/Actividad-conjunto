package com.example.demo.Servicios.Notificacion

import com.example.demo.Modelos.Notificacion.Notificacion
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NotificacionService(private val jdbcTemplate: JdbcTemplate) {

    private val rowMapper = RowMapper<Notificacion> { rs, _ ->
        Notificacion(
            id = rs.getInt("id"),
            id_usuario = rs.getInt("id_usuario"),
            mensaje = rs.getString("mensaje"),
            id_ticket = rs.getInt("id_ticket"),
            fecha_envio = rs.getTimestamp("fecha_envio")?.toLocalDateTime()
        )
    }

    fun obtenerTodas(): List<Notificacion> {
        val sql = "SELECT * FROM notificaciones"
        return jdbcTemplate.query(sql, rowMapper)
    }

    fun obtenerPorUsuario(idUsuario: Int): List<Notificacion> {
        val sql = "SELECT * FROM notificaciones WHERE id_usuario = ?"
        return jdbcTemplate.query(sql, rowMapper, idUsuario)
    }

    fun crearNotificacion(notificacion: Notificacion) {
        val sql = "INSERT INTO notificaciones (id_usuario, mensaje, id_ticket, fecha_envio) VALUES (?, ?, ?, ?)"
        val ahora = LocalDateTime.now()
        jdbcTemplate.update(sql, notificacion.id_usuario, notificacion.mensaje, notificacion.id_ticket, ahora)
    }

    fun eliminarNotificacion(id: Int) {
        val sql = "DELETE FROM notificaciones WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    fun actualizarNotificacion(id: Int, nuevaNotificacion: Notificacion) {
        val sql = """
            UPDATE notificaciones 
            SET id_usuario = ?, mensaje = ?, id_ticket = ?, fecha_envio = ? 
            WHERE id = ?
        """.trimIndent()
        jdbcTemplate.update(
            sql,
            nuevaNotificacion.id_usuario,
            nuevaNotificacion.mensaje,
            nuevaNotificacion.id_ticket,
            nuevaNotificacion.fecha_envio ?: LocalDateTime.now(),
            id
        )
    }
}
