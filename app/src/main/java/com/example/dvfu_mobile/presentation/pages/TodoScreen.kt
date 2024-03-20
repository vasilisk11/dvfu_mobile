package com.example.dvfu_mobile.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dvfu_mobile.domain.entity.TodoEntity
import com.example.dvfu_mobile.presentation.pages.view_model.TodoListViewModel
import com.example.dvfu_mobile.presentation.pages.view_model.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(
    id: Int = -1,
    viewModel: TodoViewModel,
    sharedViewModel: TodoListViewModel,
    updateTodo: (Int, String, String) -> Unit,
    addTodo: (String, String) -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.secondary,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults
                    .topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                title = {
                    if (id != -1) {
                        Text(
                            text = "Edit",
                            style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                        )
                    } else {
                        Text(
                            text = "Add Task",
                            style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .padding(horizontal = 14.dp)
                    .fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(43.dp)
            ) {
                val localModifier = Modifier.align(Alignment.CenterHorizontally)
                val textFieldColors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black,
                    cursorColor = Color.Black,
                )
                TextField(
                    value = viewModel.title.value,
                    onValueChange = {
                        viewModel.onChangeTitle(it)
                    },
                    modifier = localModifier,
                    colors = textFieldColors,
                )
                TextField(
                    value = viewModel.description.value,
                    onValueChange = {
                        viewModel.onChangeSubtitle(it)
                    },
                    modifier = localModifier,
                    colors = textFieldColors,
                )
                if (id != -1) {
                    Row(modifier = localModifier) {
                        Button(
                            onClick = {
                                updateTodo(
                                    viewModel.id.value,

                                    viewModel.title.value,
                                    viewModel.description.value
                                )
                            },
                            Modifier
                                .background(MaterialTheme.colorScheme.primary)
                                .width(386.dp)
                        ) {
                            Text(
                                text = "Update",
                                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
                            )
                        }
                        Button(
                            onClick = {},
                            Modifier
                                .background(MaterialTheme.colorScheme.primary)
                                .width(386.dp)
                        ) {
                            Text(
                                text = "Cancel",
                                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
                            )
                        }
                    }
                } else {
                    Button(
                        onClick = {
                            addTodo(
                                viewModel.title.value,
                                viewModel.description.value
                            )
                        },
                        modifier = localModifier
                            .background(MaterialTheme.colorScheme.primary)
                            .width(386.dp)
                    ) {
                        Text(
                            text = "ADD",
                            style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                        )
                    }
                }

            }
        }
    )
}
