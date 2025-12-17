package com.example.apiapplication.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.apiapplication.ui.screen.character.CharacterList
import com.example.apiapplication.ui.viewmodel.CharacterViewModel


@Composable
fun HomeScreen(
    viewModel: CharacterViewModel, onCharacterClick: (Int) -> Unit
) {
    // Observamos el estado del ViewModel
    val characters by viewModel.characters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    val filteredCharacters = characters.filter {
        it.name.contains(searchQuery.text, ignoreCase = true)
    }

    // Carga inicial de datos
    LaunchedEffect(Unit) {
        viewModel.loadCharacters()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        when {
            isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            characters.isEmpty() -> {
                Text(text = "No characters found")
            }

            else -> {
                CharacterList(
                    characters = filteredCharacters, onCharacterClick = onCharacterClick


                )
            }
        }
    }

}