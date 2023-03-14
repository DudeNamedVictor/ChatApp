package com.example.chatapp.ui.allchats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.MainApplication
import com.example.chatapp.data.repositories.AllChatsRepositoryImpl
import com.example.chatapp.data.services.ChatsServices
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllChatsViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var services: ChatsServices

    init {
        getApplication<MainApplication>().appComponent.inject(this)

        viewModelScope.launch {

            val a =
                AllChatsRepositoryImpl(services).getAllChats()
            a
        }
    }

}