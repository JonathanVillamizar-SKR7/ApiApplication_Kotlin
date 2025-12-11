package com.example.apiapplication.data.remote

/**
 * La API devuelve un JSON con esta estructura:
 *
 * {
 *   "characters": [ { ...personaje... }, { ... } ]
 * }
 *
 * Por eso necesitamos esta clase, que envuelve la lista.
 */
data class Data (
    val characters: List<DataItem>
)