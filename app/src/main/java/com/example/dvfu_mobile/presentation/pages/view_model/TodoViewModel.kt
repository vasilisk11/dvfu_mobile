
package com.example.dvfu_mobile.presentation.pages.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dvfu_mobile.domain.entity.TodoEntity

class TodoViewModel: ViewModel() {
    var title = mutableStateOf("")
        private set
    var description = mutableStateOf("")
        private set

    var id = mutableStateOf(0)

    fun setTodo(todo: TodoEntity){
        title.value = todo.title
        description.value = todo.subtitle
        id.value = todo.id
    }

    fun onChangeTitle(value: String){
        title.value = value
    }

    fun onChangeSubtitle(value: String){
        description.value = value
    }

}