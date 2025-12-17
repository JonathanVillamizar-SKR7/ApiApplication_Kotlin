package com.example.apiapplication.ui.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.apiapplication.ui.viewmodel.CharacterViewModel

@Composable
fun DetailScreen(
    characterId: Int, viewModel: CharacterViewModel
) {
    val characters by viewModel.characters.collectAsState()

    val character = characters.firstOrNull { it.id == characterId }

    if (character == null) {
        Text(
            text = "Character not found", modifier = Modifier.padding(16.dp)
        )
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        // Imagen principal
        AsyncImage(
            model = character.image,
            contentDescription = character.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            contentScale = ContentScale.Crop
        )

        // Card con información
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = character.name, style = MaterialTheme.typography.headlineSmall
                )

                character.clan?.let {
                    Text(
                        text = "Clan: $it", style = MaterialTheme.typography.bodyMedium
                    )
                }

                character.affiliation?.let {
                    Text(
                        text = "Affiliation: $it", style = MaterialTheme.typography.bodyMedium
                    )
                }

                character.kekkeiGenkai?.takeIf { it.isNotEmpty() }?.let {
                    Text(
                        text = "Kekkei Genkai: ${it.joinToString()}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                character.natureTypes?.takeIf { it.isNotEmpty() }?.let {
                    Text(
                        text = "Nature Types: ${it.joinToString()}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
