package com.example.chatapp.data.models.requests

data class ChatsModel(
    val id: String,
    val name: String,
    val lastMassage: LastMessage
)

data class LastMessage(
    val id: String,
    val chatId: String,
    val author: Author,
    val text: String
)

data class Author(
    val id: String,
    val userName: String,
)