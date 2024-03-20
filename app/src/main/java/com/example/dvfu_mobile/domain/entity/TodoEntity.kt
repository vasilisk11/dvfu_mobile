package com.example.dvfu_mobile.domain.entity

data class TodoEntity(
    val title: String,
    val subtitle: String,
    val id: Int? = null
)