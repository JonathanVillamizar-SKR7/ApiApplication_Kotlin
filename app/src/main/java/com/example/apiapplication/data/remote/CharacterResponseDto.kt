package com.example.apiapplication.data.remote

import com.google.gson.annotations.SerializedName

// Representa el JSON raíz
// Mapea la lista "Characters"
data class CharacterResponseDto(
    @SerializedName("characters")
    val characters: List<CharacterDto>
) {
}