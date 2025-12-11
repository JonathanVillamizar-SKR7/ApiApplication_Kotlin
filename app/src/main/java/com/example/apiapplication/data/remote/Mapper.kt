package com.example.apiapplication.data.remote

import com.example.apiapplication.domain.model.Character


/**
 * Extensión que convierte un DataItem (DTO) en un Character (modelo de dominio).
 *
 * Se usa en el repositorio para desacoplar Data → Domain.
 */
fun DataItem.toDomain(): Character {
    return Character(
        id = id,
        name = name ?: "Unknown",
        image = images?.firstOrNull(),
        clan = personal?.clan,
        affiliation = personal?.affiliation?.firstOrNull(),
        kekkeiGenkai = personal?.kekkeiGenkai,
        natureTypes = natureType
    )
}