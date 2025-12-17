package com.example.apiapplication.ui.screen.home

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun SearchBar(
    // TextFieldValue:
    // Permite control total del texto
    query: TextFieldValue, onQueryChange: (TextFieldValue) -> Unit, modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query, onValueChange = onQueryChange, modifier = modifier, placeholder = {
            Text(text = "Search character")
        }, singleLine = true
    )
}