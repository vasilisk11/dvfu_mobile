package com.example.dvfu_mobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.dvfu_mobile.domain.entity.TodoEntity
import com.example.dvfu_mobile.presentation.pages.TodoList
import com.example.dvfu_mobile.presentation.pages.TodoScreen
import com.example.dvfu_mobile.presentation.pages.view_model.TodoListViewModel
import com.example.dvfu_mobile.presentation.pages.view_model.TodoViewModel

@Composable
fun AppNavController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.TodoModule.route,
    ) {
        navigation(
            route = Screen.TodoModule.route,
            startDestination = Screen.TodoListScreen.route,
        ) {
            composable(route = Screen.TodoListScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<TodoListViewModel>(navController)
                TodoList(navController = navController, viewModel = viewModel)
            }
            composable(
                route = Screen.TodoScreen.route + "/{title}/{description}",
                arguments = listOf(
                    navArgument("title") {
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
            ) { entry ->
                val viewModel = entry.sharedViewModel<TodoViewModel>(navController)
                val todoViewModel = entry.sharedViewModel<TodoListViewModel>(navController = navController)

                TodoScreen(
                    title = entry.arguments?.getString("title"),
                    subtitle = entry.arguments?.getString("description"),
                    navController = navController,
                    viewModel = viewModel,
                    updateTodo = {
                        todoViewModel.editTodo(it)
                    },
                    addTodo = {
                        todoViewModel.addTodo(it.title, it.subtitle)
                    }
                )
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}

