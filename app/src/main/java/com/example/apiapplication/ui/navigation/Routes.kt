package com.example.apiapplication.ui.navigation

object Routes {
    const val HOME = "home"
    const val DETAIL = "detail"

    fun detailRoute(characterId: Int): String {
        return "$DETAIL/$characterId"
    }
}


