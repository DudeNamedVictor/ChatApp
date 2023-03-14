package com.example.chatapp.data.services

import com.example.chatapp.data.api.Api
import com.example.chatapp.data.models.requests.ChatsModel
import com.example.chatapp.data.utils.BaseService

class ChatsServices(baseService: BaseService) {

    private var api: Api = baseService.createService().create(Api::class.java)

    suspend fun getAllChats(): List<ChatsModel> = api.getAllChats()

}