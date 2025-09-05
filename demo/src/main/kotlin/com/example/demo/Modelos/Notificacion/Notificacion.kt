package com.example.demo.Modelos.Notificacion

data class Notificacion(
    val id: Int? = null,
    val usuario_id: Int,
    val ticket_id: Int,
    val fecha_envio: String? = null,
    val creado_en: String? = null,
    val actualizado_en: String? = null
)
