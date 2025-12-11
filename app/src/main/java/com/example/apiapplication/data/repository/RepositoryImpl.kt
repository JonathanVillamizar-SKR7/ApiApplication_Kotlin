package com.example.apiapplication.data.repository


import com.example.apiapplication.data.remote.ApiInterface
import com.example.apiapplication.data.remote.toDomain
import com.example.apiapplication.domain.model.Character
import com.example.apiapplication.domain.repository.Repository

/**
 * Implementación del repositorio.
 *
 * Aquí se combinan Retrofit (API) + mapping DTO → dominio.
 */
class RepositoryImpl(
    private val api: ApiInterface = ApiInterface.create()
) : Repository {

    override suspend fun getCharacters(): List<Character> {
        val response = api.getCharacters()

        if (response.isSuccessful) {
            val data = response.body()
            return data?.characters?.map { it.toDomain() } ?: emptyList()
        }

        throw Exception("API error: ${response.code()}")
    }
}