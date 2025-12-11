package com.example.apiapplication.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Interfaz Retrofit que define los endpoints de la API.
 *
 * Cada función corresponde a un endpoint de la API real.
 * Retrofit genera automáticamente la implementación.
 */
interface ApiInterface {
    /**
     * GET /characters
     *
     * Devuelve un Response<Data> donde Data contiene la lista
     * de personajes dentro del campo "characters".
     */
    @GET("characters")
    suspend fun getCharacters(): Response<Data>

    /**
     * Companion object para crear una instancia de Retrofit
     * sin necesidad de usar Dagger/Hilt.
     */
    companion object {
        private const val BASE_URL = "https://dattebayo-api.onrender.com/" // Base URL de la API

        /**
         * Crea el cliente Retrofit ya configurado.
         *
         * - Logging interceptor: imprime todas las peticiones/respuestas JSON
         * - GsonConverterFactory: convierte JSON ↔ objetos Kotlin
         * - OkHttpClient: motor HTTP que usa Retrofit debajo
         */
        fun create(): ApiInterface {
            // Interceptor que muestra las peticiones en Logcat
            val logging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            // Cliente HTTP
            val client = OkHttpClient.Builder().addInterceptor(logging).build()
            // Construcción del objeto Retrofit
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client).build()
                .create(ApiInterface::class.java)
        }

    }

}