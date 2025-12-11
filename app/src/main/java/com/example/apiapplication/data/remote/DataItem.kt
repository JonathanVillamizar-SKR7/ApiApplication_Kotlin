package com.example.apiapplication.data.remote

/**
 * DTO (Data Transfer Object) que representa
 * un personaje tal como viene desde la API.
*/
data class DataItem(
    val id: Int,
    val name: String?,
    val images: List<String>?,
    val personal: Personal?,
    val natureType: List<String>?
)

/**
 * DTO secundario que representa la sección "personal"
 * del JSON del personaje.
 */
data class Personal(
    val clan: String?,
    val affiliation: List<String>?,
    val kekkeiGenkai: List<String>?
)
