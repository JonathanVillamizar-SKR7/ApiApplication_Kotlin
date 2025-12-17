package com.example.apiapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.apiapplication.data.remote.ApiInterface
import com.example.apiapplication.data.repository.CharacterRepositoryImpl
import com.example.apiapplication.ui.navigation.NavGraph
import com.example.apiapplication.ui.theme.ApiApplicationTheme
import com.example.apiapplication.ui.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Se crean las dependencias manualmente
        val api = ApiInterface.create()
        val repository = CharacterRepositoryImpl(api)
        val characterViewModel = CharacterViewModel(repository)

        setContent {
            ApiApplicationTheme {
                NavGraph(viewModel = characterViewModel)
            }
        }
    }
}
