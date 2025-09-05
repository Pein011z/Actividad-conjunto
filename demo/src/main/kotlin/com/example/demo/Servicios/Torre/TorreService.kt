package com.example.demo.Servicios.Torre

import com.example.demo.Modelos.Torre.Torre
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class TorreService(private val jdbcTemplate: JdbcTemplate) {

    fun obtenerTorre(): List<String> {
        val sql = "SELECT id, nombre, creado_en, actualizado_en FROM torre"
        return jdbcTemplate.query(sql, RowMapper<String> { rs, _ ->
            "id: ${rs.getInt("id")} - Nombre: ${rs.getString("nombre")} - CreadoEn: ${rs.getString("creado_en")} - ActualizadoEn: ${rs.getString("actualizado_en")}"
        })
    }

    fun crearTorre(torre: Torre) {
        val sql = """
            INSERT INTO torre (nombre) 
            VALUES (?)
        """
        jdbcTemplate.update(sql, torre.nombre)
    }

    fun eliminarTorre(id: Int) {
        val sql = "DELETE FROM torre WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    fun actualizarTorre(id: Int, torre: Torre) {
        val sql = "UPDATE torre SET nombre = ? WHERE id = ?"
        jdbcTemplate.update(sql, torre.nombre, id)
    }
}