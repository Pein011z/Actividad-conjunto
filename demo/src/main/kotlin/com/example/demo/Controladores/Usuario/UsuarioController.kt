package com.example.demo.Controller.Usuario

import com.example.demo.Modelos.Usuario.Usuario
import com.example.demo.Servicios.Usuario.UsuarioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController(val usuarioService: UsuarioService) {

    @GetMapping
    fun obtenerUsuario():List<String> {
        return usuarioService.obtenerUsuario()
    }

    @PostMapping
    fun crearUsuario(@RequestBody usuario: Usuario): String {
        usuarioService.crearUsuario(usuario)
        return "Usuario creado correctamente"
    }

    @DeleteMapping("/{id}")
    fun eliminarUsuario(@PathVariable id: Int): String {
        usuarioService.eliminarUsuario(id)
        return "Usuario eliminado correctamente"
    }

    @PutMapping("/{id}")
    fun editarUsuario(@PathVariable id: Int, @RequestBody usuario: Usuario): String {
        usuarioService.editarUsuario(id, usuario)
        return "Usuario actualizado correctamente"
    }

    @PostMapping("/login")
    fun login(@RequestBody datosLogin: Map<String, String>): Any {
        val correo = datosLogin["correo"] ?: return "Correo requerido"
        val contraseña = datosLogin["contraseña"] ?: return "Contraseña requerida"

        val usuario = usuarioService.login(correo, contraseña)
        return usuario ?: "Credenciales incorrectas"
    }
}