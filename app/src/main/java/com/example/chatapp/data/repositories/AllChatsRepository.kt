package com.example.chatapp.data.repositories

import com.example.chatapp.data.models.requests.ChatsModel
import com.example.chatapp.data.services.ChatsServices
import javax.inject.Inject

interface AllChatsRepository {
    suspend fun getAllChats(): List<ChatsModel>
}

class AllChatsRepositoryImpl @Inject constructor(
    private val services: ChatsServices
) : AllChatsRepository {

    override suspend fun getAllChats(): List<ChatsModel> = services.getAllChats()

}