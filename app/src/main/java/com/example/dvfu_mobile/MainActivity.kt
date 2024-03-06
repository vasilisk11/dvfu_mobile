package com.example.dvfu_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dvfu_mobile.presentation.TodoCard
import com.example.dvfu_mobile.ui.theme.DVFU_mobileTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DVFU_mobileTheme {
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults
                                .smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                            title = {
                                Text(
                                    "TODO APP",
                                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                                )
                            })
                    },
                    bottomBar = {
                        NavigationBar {
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
                                icon = { Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = ""
                                )})
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                        }) {
                            Icon(
                                Icons.Filled.Add,
                                "Add todo"
                            )
                        }
                    },
                    content = { padding ->
                        Column(
                            modifier = Modifier
                                .padding(padding)
                                .padding(top = 22.dp, start = 7.dp, end = 7.dp),
                            verticalArrangement = Arrangement.spacedBy(21.dp)
                        ) {
                            TodoCard("Вынести мусор", "Ибо воняет")
                            TodoCard(
                                "Сходить на пару",
                                "Сходить на пару по мобильной разработке"
                            )
                            TodoCard(
                                "Сходить на пару",
                                "Сходить на пару по мобильной разработке"
                            )
                            TodoCard(
                                "Сходить на пару",
                                "Сходить на пару по мобильной разработке"
                            )
                            TodoCard(
                                "Сходить на пару",
                                "Сходить на пару по мобильной разработке"
                            )
                        }
                    })
            }
        }
    }
}
