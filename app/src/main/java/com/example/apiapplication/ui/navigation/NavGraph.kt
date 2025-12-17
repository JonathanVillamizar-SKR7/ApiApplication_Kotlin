package com.example.apiapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.apiapplication.ui.screen.detail.DetailScreen
import com.example.apiapplication.ui.screen.home.HomeScreen
import com.example.apiapplication.ui.viewmodel.CharacterViewModel

@Composable
fun NavGraph(
    viewModel: CharacterViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        // HOME
        composable(Routes.HOME) {
            HomeScreen(
                viewModel = viewModel,
                onCharacterClick = { id ->
                    navController.navigate(Routes.detailRoute(id))
                }
            )
        }

        // DETAIL
        composable(
            route = "${Routes.DETAIL}/{characterId}",
            arguments = listOf(
                navArgument("characterId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val characterId =
                backStackEntry.arguments?.getInt("characterId")
                    ?: return@composable

            DetailScreen(
                characterId = characterId,
                viewModel = viewModel
            )
        }
    }
}
