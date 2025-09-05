package com.example.demo.Modelos.Usuario

data class Usuario(
    val id: Int? = null,
    val nombres: String,
    val apellidos: String,
    val torre_id: Int,
    val correo: String,
    val contraseña: String
)