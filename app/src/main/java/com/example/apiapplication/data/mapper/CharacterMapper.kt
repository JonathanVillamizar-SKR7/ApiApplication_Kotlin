package com.example.apiapplication.data.mapper

import com.example.apiapplication.data.remote.dto.CharacterDto
import com.example.apiapplication.domain.model.Character

// Mapper que convierte un CharacterDto (API)
// en un Character (modelo de dominio).
// Esto evita que la UI dependa del formato del JSON
fun CharacterDto.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        image = images?.firstOrNull(),
        clan = when (val c = personal?.clan) {
            is String -> c
            is List<*> -> c.firstOrNull()?.toString()
            else -> null
        }, affiliation = when (val a = personal?.affiliation) {
            is String -> a
            is List<*> -> a.joinToString(", ")
            else -> null
        },
        kekkeiGenkai = kekkeiGenkai,
        natureTypes = natureTypes
    )
}
