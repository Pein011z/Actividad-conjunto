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
            id_ticket = rs.getInt("id_ticket"),
            fecha_envio = rs.getTimestamp("fecha_envio").toLocalDateTime(),
            creado_en = rs.getTimestamp("creado_en").toLocalDateTime(),
            actualizado_en = rs.getTimestamp("actualizado_en").toLocalDateTime()
        )
    }

    fun obtenerTodas(): List<Notificacion> {
        val sql = "SELECT * FROM notificacion"
        return jdbcTemplate.query(sql, rowMapper)
    }

    fun obtenerPorUsuario(idUsuario: Int): List<Notificacion> {
        val sql = "SELECT * FROM notificacion WHERE id_usuario = ?"
        return jdbcTemplate.query(sql, rowMapper, idUsuario)
    }

    fun crearNotificacion(notificacion: Notificacion) {
        val ahora = LocalDateTime.now()
        val sql = """
            INSERT INTO notificacion (id_usuario, id_ticket, fecha_envio, creado_en, actualizado_en) 
            VALUES (?, ?, ?, ?, ?)
        """.trimIndent()
        jdbcTemplate.update(
            sql,
            notificacion.id_usuario,
            notificacion.id_ticket,
            notificacion.fecha_envio,
            ahora,
            ahora
        )
    }

    fun eliminarNotificacion(id: Int) {
        val sql = "DELETE FROM notificacion WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    fun actualizarNotificacion(id: Int, nuevaNotificacion: Notificacion) {
        val ahora = LocalDateTime.now()
        val sql = """
            UPDATE notificacion
            SET id_usuario = ?, id_ticket = ?, fecha_envio = ?, actualizado_en = ?
            WHERE id = ?
        """.trimIndent()
        jdbcTemplate.update(
            sql,
            nuevaNotificacion.id_usuario,
            nuevaNotificacion.id_ticket,
            nuevaNotificacion.fecha_envio,
            ahora,
            id
        )
    }
}
