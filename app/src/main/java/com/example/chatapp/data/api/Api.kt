package com.example.chatapp.data.api

import com.example.chatapp.data.models.requests.ChatsModel
import retrofit2.http.GET

interface Api {
    @GET("v1/main")
    suspend fun getAllChats(): List<ChatsModel>
}