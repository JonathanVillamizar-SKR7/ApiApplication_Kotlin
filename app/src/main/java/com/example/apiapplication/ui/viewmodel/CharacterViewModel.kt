package com.example.apiapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiapplication.domain.model.Character
import com.example.apiapplication.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Clase de ViewModel
// El viewModel depende de la interfaz del dominio, no del retrofit
// Clean Architecture puro
class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {
    // StateFlow para almacenar la lista de personajes
    // Estado observable : _characters es interno
    // characters es lo que ve la ui
    // MVVM básico
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    // Esto para mostrar el spinner y saber si la API está cargando
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        // No bloque la UI (viewModelScope)
        viewModelScope.launch { // Corrutina
            _isLoading.value = true
            try {
                _characters.value = repository.getCharacters() // capa data
            } catch (e: Exception) {
                // Manejar errores
            } finally {
                _isLoading.value = false
            }
        }
    }
}