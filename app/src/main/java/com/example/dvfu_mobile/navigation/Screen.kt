package com.example.dvfu_mobile.navigation

sealed class Screen(val route: String) {
    object TodoListScreen: Screen ("todo_list_screen")
    object TodoScreen : Screen( "todo_screen")
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
