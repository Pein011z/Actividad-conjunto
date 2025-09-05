package com.example.demo.Controladores.TipoSolicitud

import com.example.demo.Modelos.TipoSolicitud.TipoSolicitud
import com.example.demo.Servicios.TipoSolicitud.TipoSolicitudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tipo_solicitud")
class TipoSolicitudController(@Autowired val tipoSolicitudService: TipoSolicitudService) {

    @GetMapping
    fun obtenerTiposSolicitud(): List<String> {
        return tipoSolicitudService.obtenerTiposSolicitud()
    }

    @PostMapping
    fun crearTipoSolicitud(@RequestBody tipoSolicitud: TipoSolicitud): String {
        tipoSolicitudService.crearTipoSolicitud(tipoSolicitud)
        return "Tipo de solicitud creado correctamente"
    }

    @DeleteMapping("/{id}")
    fun eliminarTipoSolicitud(@PathVariable id: Int): String {
        tipoSolicitudService.eliminarTipoSolicitud(id)
        return "Tipo de solicitud eliminado correctamente"
    }

    @PutMapping("/{id}")
    fun actualizarTipoSolicitud(@PathVariable id: Int, @RequestBody tipoSolicitud: TipoSolicitud): String {
        tipoSolicitudService.actualizarTipoSolicitud(id, tipoSolicitud)
        return "Tipo de solicitud actualizado correctamente"
    }
}