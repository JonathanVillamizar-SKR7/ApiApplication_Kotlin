package com.example.apiapplication.data.mapper

import com.example.apiapplication.data.remote.dto.CharacterDto
import com.example.apiapplication.domain.model.Character

// Mapper que convierte un CharacterDto (API)
// en un Character (modelo de dominio).
// Esto evita que la UI dependa del formato del JSON
fun CharacterDto.toDomain(): Character {
    return Character(
        id = id,
        name = name ?: "Unknown",
        image = images?.firstOrNull(), // usamos solo la primera imagen
        clan = personal?.clan,
        affiliation = personal?.affiliation?.firstOrNull(),
        kekkeiGenkai = kekkeiGenkai,
        natureTypes = natureTypes
    )
}
