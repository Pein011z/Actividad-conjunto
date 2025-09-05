package com.example.demo.Modelos.Ticket

data class Ticket(
    val id: Int? = null,
    val usuario_id: Int,
    val tipo_solicitud_id: Int,
    val titulo: String,
    val descripcion: String,
    val estado_ticket_id: Int,
    val creado_en: String? = null,
    val actualizado_en: String? = null
)