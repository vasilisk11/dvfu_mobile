
package com.example.dvfu_mobile.presentation.pages.view_model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.dvfu_mobile.domain.entity.TodoEntity

class TodoListViewModel : ViewModel() {

    var todoList = mutableStateListOf(
        TodoEntity(
            title = "Сходить на пару",
            subtitle = "Сходить на пару по мобильной разработке",
            id = 0
        ),
        TodoEntity(
            title = "Сходить на пару 1",
            subtitle = "Сходить на первую пару по мобильной разработке",
            id = 1
        ),
        TodoEntity(
            title = "Сходить на пару 2",
            subtitle = "Сходить на вторую пару по мобильной разработке",
            id = 2
        ),
        TodoEntity(
            title = "Сходить на пару 3",
            subtitle = "Сходить на третью пару по мобильной разработке",
            id = 3
        )
    )
        private set


    fun addTodo(title: String, subtitle: String) {
        todoList.add(TodoEntity(title = title, subtitle = subtitle, id = todoList.size))
    }

    fun deleteTodo(id: Int) {

    }

    fun editTodo(id: Int, title: String, subtitle: String) {
        todoList[id] = todoList[id].copy(title = title, subtitle = subtitle)
    }
}