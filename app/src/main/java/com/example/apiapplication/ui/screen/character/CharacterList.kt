package com.example.apiapplication.ui.screen.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apiapplication.domain.model.Character


// Lista de personajes
// Equivale conceptualmente a un recyclerView
// Usa LazyColumn para renderizar solo los elementos visibles
@Composable
fun CharacterList(
    characters: List<Character>, onCharacterClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(characters) { character ->
            CharacterItem(
                character = character, onClick = { onCharacterClick(character.id) })
        }
    }
}
