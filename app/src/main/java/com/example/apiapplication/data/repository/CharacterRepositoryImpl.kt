package com.example.apiapplication.data.repository

import com.example.apiapplication.data.mapper.toDomain
import com.example.apiapplication.data.remote.ApiInterface
import com.example.apiapplication.domain.model.Character
import com.example.apiapplication.domain.repository.CharacterRepository

// Implementación del repositorio de dominio
// Aquí se llama a la API y se mapean los datos transformando el DTO a dominio
class CharacterRepositoryImpl(
    private val api: ApiInterface
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        val response = api.getCharacters()

        if (response.isSuccessful) {
            val body = response.body()
            return body?.characters?.map { it.toDomain() } ?: emptyList()
        } else {
            throw Exception("API error")
        }
    }

}
