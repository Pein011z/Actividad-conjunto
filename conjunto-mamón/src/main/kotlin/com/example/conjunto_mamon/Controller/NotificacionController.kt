package com.example.demo.Controller.Notificacion

import com.example.demo.Modelos.Notificacion.Notificacion
import com.example.demo.Servicios.Notificacion.NotificacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notificaciones")
class NotificacionController(@Autowired val notificacionService: NotificacionService) {

    @GetMapping
    fun obtenerTodas(): List<Notificacion> = notificacionService.obtenerTodas()

    @GetMapping("/usuario/{idUsuario}")
    fun obtenerPorUsuario(@PathVariable idUsuario: Int): List<Notificacion> =
        notificacionService.obtenerPorUsuario(idUsuario)

    @PostMapping
    fun crearNotificacion(@RequestBody notificacion: Notificacion): String {
        notificacionService.crearNotificacion(notificacion)
        return "Notificación creada correctamente"
    }

    @DeleteMapping("/{id}")
    fun eliminarNotificacion(@PathVariable id: Int): String {
        notificacionService.eliminarNotificacion(id)
        return "Notificación eliminada"
    }

    @PutMapping("/{id}")
    fun actualizarNotificacion(@PathVariable id: Int, @RequestBody notificacion: Notificacion): String {
        notificacionService.actualizarNotificacion(id, notificacion)
        return "Notificación actualizada"
    }
}
