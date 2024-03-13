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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(title: String? = null, subtitle: String? = null, navController: NavController) {
    var titleState by remember { mutableStateOf(title ?:"") }
    var descriptionState by remember { mutableStateOf(subtitle ?:"") }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.secondary,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults
                    .smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                title = {
                    if (title != null && subtitle != null) {
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
                    .padding(paddingValues = it).padding(horizontal = 14.dp)
                    .fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(43.dp)
            ) {
                val localModifier = Modifier.align(Alignment.CenterHorizontally)
                val textFieldColors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black,
                    cursorColor = Color.Black,
                )
                TextField(
                    value = titleState,
                    onValueChange = {titleState = it},
                    modifier = localModifier,
                    colors = textFieldColors,
                )
                TextField(
                    value = descriptionState,
                    onValueChange = {descriptionState = it},
                    modifier = localModifier,
                    colors = textFieldColors,
                )
                if (title != null && subtitle != null) {
                    Row(modifier = localModifier) {
                        Button(
                            onClick = {},
                            Modifier.background(MaterialTheme.colorScheme.primary).width(386.dp)
                        ) {
                            Text(
                                text = "Update",
                                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
                            )
                        }
                        Button(
                            onClick = {},
                            Modifier.background(MaterialTheme.colorScheme.primary).width(386.dp)
                        ) {

                            Text(
                                text = "Cancel",
                                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
                            )
                        }
                    }
                } else {
                    Button(
                        onClick = {},
                        modifier = localModifier.background(MaterialTheme.colorScheme.primary).width(386.dp)
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
