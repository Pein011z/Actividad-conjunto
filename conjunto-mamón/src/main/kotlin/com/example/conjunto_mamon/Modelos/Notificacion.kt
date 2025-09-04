package com.example.demo.Modelos.Notificacion

import java.time.LocalDateTime

data class Notificacion(
    val id: Int? = null,
    val id_usuario: Int,
    val id_ticket: Int,
    val fecha_envio: LocalDateTime,
    val creado_en:  LocalDateTime,
    val actualizado_en: LocalDateTime
)
