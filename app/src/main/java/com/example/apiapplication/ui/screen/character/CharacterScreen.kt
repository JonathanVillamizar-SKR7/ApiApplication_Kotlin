package com.example.apiapplication.ui.screen.character

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apiapplication.ui.viewmodel.CharacterViewModel


// Pantalla que muestra la lista de personajes
// Uso LazyColumn ya que es el equivalente a RecyclerView pero de JetpackCompose y más moderno.
@Composable
fun CharacterScreen(
    viewModel: CharacterViewModel
) {
    // Observo el stateFlow del ViewModel
    val characters by viewModel.characters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    // Convierte StateFlow en estado observable de Compose.
    // Cuando cambia la lista: la UI se redibuja sola.

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Estado de carga
        // Si está cargando, muestra un spinner
        // Estados de UI / Feedback al usuario
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Lista de personajes
        // Lista eficiente / Renderizado bajo demanda / reutilización de vistas
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(characters) { character ->
                // CharacterItem
                Text(text = character.name)
            }
        }

    }
}