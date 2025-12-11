package com.example.apiapplication.domain.repository

import com.example.apiapplication.domain.model.Character

/**
 * Interfaz del repositorio que la capa de dominio usa.
 *
 * Data implementará esta interfaz, pero Domain nunca conocerá Retrofit.
 */
interface Repository {
    suspend fun getCharacters(): List<Character>
}

