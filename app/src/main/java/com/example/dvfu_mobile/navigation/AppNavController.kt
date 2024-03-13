package com.example.dvfu_mobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dvfu_mobile.presentation.pages.TodoList
import com.example.dvfu_mobile.presentation.pages.TodoScreen


@Composable
fun AppNavController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.TodoListScreen.route) {
        composable(route = Screen.TodoListScreen.route) {
            TodoList(navController = navController)
        }
        composable (
            route = Screen.TodoScreen.route + "/{title}/{description}",
            arguments = listOf(
                navArgument("title"){
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                },
                navArgument("description") {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                }
            ),
        ){
            TodoScreen(
                title = it.arguments?.getString("title"),
                subtitle = it.arguments?.getString("description"),
                navController = navController
            )
        }

    }
}




