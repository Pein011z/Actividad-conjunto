package com.example.demo.Servicios.TipoSolicitud

import com.example.demo.Modelos.TipoSolicitud.TipoSolicitud
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class TipoSolicitudService(private val jdbcTemplate: JdbcTemplate) {

    fun obtenerTiposSolicitud(): List<String> {
        val sql = "SELECT id, nombre, creado_en, actualizado_en FROM tipo_solicitud"
        return jdbcTemplate.query(sql, RowMapper<String> { rs, _ ->
            "id: ${rs.getInt("id")} - Nombre: ${rs.getString("nombre")} - CreadoEn: ${rs.getString("creado_en")} - ActualizadoEn: ${rs.getString("actualizado_en")}"
        })
    }

    fun crearTipoSolicitud(tipoSolicitud: TipoSolicitud) {
        val sql = """
            INSERT INTO tipo_solicitud (nombre) 
            VALUES (?)
        """
        jdbcTemplate.update(sql, tipoSolicitud.nombre)
    }

    fun eliminarTipoSolicitud(id: Int) {
        val sql = "DELETE FROM tipo_solicitud WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    fun actualizarTipoSolicitud(id: Int, tipoSolicitud: TipoSolicitud) {
        val sql = """
            UPDATE tipo_solicitud 
            SET nombre = ? 
            WHERE id = ?
        """
        jdbcTemplate.update(sql, tipoSolicitud.nombre, id)
    }
}