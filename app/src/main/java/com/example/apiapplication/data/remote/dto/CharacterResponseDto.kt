package com.example.apiapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

// Representa el JSON raíz del endpoint /characters
data class CharacterResponseDto(
    @SerializedName("characters")
    val characters: List<CharacterDto>
)
