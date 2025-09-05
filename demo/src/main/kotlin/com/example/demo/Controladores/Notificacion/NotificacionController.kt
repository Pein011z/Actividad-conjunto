package com.example.demo.Controladores.Notificacion

import com.example.demo.Modelos.Notificacion.Notificacion
import com.example.demo.Servicios.Notificacion.NotificacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class NotificacionController(@Autowired val notificacionService: NotificacionService) {

    @GetMapping("/notificaciones")
    fun obtenerNotificaciones(): List<String> {
        return notificacionService.obtenerNotificaciones()
    }

    @PostMapping("/notificaciones")
    fun crearNotificacion(@RequestBody notificacion: Notificacion): String {
        notificacionService.crearNotificacion(notificacion)
        return "Notificación creada correctamente"
    }

    @DeleteMapping("/notificaciones/{id}")
    fun eliminarNotificacion(@PathVariable id: Int): String {
        notificacionService.eliminarNotificacion(id)
        return "Notificación eliminada correctamente"
    }

    @PutMapping("/notificaciones/{id}")
    fun actualizarNotificacion(@PathVariable id: Int, @RequestBody notificacion: Notificacion): String {
        notificacionService.actualizarNotificacion(id, notificacion)
        return "Notificación actualizada correctamente"
    }
}
