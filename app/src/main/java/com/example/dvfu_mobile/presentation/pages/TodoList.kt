package com.example.dvfu_mobile.presentation.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dvfu_mobile.domain.entity.TodoEntity
import com.example.dvfu_mobile.navigation.Screen
import com.example.dvfu_mobile.presentation.TodoCard
import com.example.dvfu_mobile.presentation.components.TodoCard
import com.example.dvfu_mobile.presentation.pages.view_model.TodoListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoList(navController: NavController, viewModel: TodoListViewModel) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.secondary,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "TODO APP",
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                    )
                })
        },
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = ""
                        )
                    });
                NavigationBarItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = ""
                        )
                    })
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        Screen.TodoScreen.withArgs("-1")
                    )
                }) {
                Icon(
                    Icons.Filled.Add,
                    "Add todo"
                )
            }
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(top = 22.dp, start = 7.dp, end = 7.dp),
                verticalArrangement = Arrangement.spacedBy(21.dp)
            ) {
                items(viewModel.todoList) {
                    TodoCard(
                        title = it.title,
                        subtitle = it.subtitle,
                        onClick = {
                            navController.navigate(
                                Screen.TodoScreen.withArgs(
                                    it.id.toString()
                                )
                            )
                        },
                        onDelete = {viewModel.deleteTodo(it.id)}
                    )

                }
            }
        })
}

