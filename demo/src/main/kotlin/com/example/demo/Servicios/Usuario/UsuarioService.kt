package com.example.demo.Servicios.Usuario

import com.example.demo.Modelos.Usuario.Usuario
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val jdbcTemplate: JdbcTemplate) {

    fun obtenerUsuario(): List<String> {
        val sql = "SELECT id, nombres, apellidos, torre_id, correo, contraseña FROM usuario"
        return jdbcTemplate.query(sql, RowMapper<String> { rs, _ ->
            "id: ${rs.getInt("id")} - nombres: ${rs.getString("nombres")} ${rs.getString("apellidos")} ${rs.getInt("torre_id")} - correo: ${rs.getString("correo")} ${rs.getString("contraseña")}"
        })
    }

    fun crearUsuario(usuario: Usuario) {
        val sql = "INSERT INTO usuario (nombres, apellidos, torre_id, correo, contraseña) VALUES (?, ?, ?, ?, ?)"
        jdbcTemplate.update(sql, usuario.nombres,usuario.apellidos, usuario.torre_id, usuario.correo, usuario.contraseña)
    }

    fun eliminarUsuario(id: Int) {
        val sql = "DELETE FROM usuario WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    fun editarUsuario(id: Int, usuario: Usuario) {
        val sql = "UPDATE usuario SET nombres = ?, apellidos = ?, torre_id = ?, correo = ?, contraseña = ? WHERE id = ?"
        jdbcTemplate.update(sql, usuario.nombres, usuario.apellidos, usuario.torre_id, usuario.correo, usuario.contraseña, id)
    }

    private val rowMapper = RowMapper<Usuario> { rs, _ ->
        Usuario(
            id = rs.getInt("id"),
            nombres = rs.getString("nombres"),
            apellidos = rs.getString("apellidos"),
            torre_id = rs.getInt("torre_id"),
            correo = rs.getString("correo"),
            contraseña = rs.getString("contraseña")
        )
    }

    fun login(correo: String, contraseña: String): Usuario? {
        val sql = "SELECT * FROM usuario WHERE correo = ? AND contraseña = ?"
        return jdbcTemplate.query(sql, rowMapper, correo, contraseña).firstOrNull()
    }
}