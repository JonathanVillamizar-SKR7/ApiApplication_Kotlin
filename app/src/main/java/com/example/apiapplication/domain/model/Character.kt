package com.example.apiapplication.domain.model

/**
 * Modelo de dominio del personaje.
 *
 * Este modelo NO depende de Retrofit ni de cómo la API envía los datos.
 * Es estable, seguro y solo contiene lo que la UI necesita mostrar.
 */
data class Character(
    val id: Int,
    val name: String,
    val image: String?,
    val clan: String?,
    val affiliation: String?,
    val kekkeiGenkai: List<String>?,
    val natureTypes: List<String>?
)