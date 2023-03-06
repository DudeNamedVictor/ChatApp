package com.example.chatapp.ui.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    val stateMLD: MutableLiveData<SplashScreenState> = MutableLiveData()

    init {
        viewModelScope.launch {
            // todo: реализовать логику проверки авторизации, когда будет бэк
            delay(3000)
            stateMLD.value = SplashScreenState.LoginSuccess
        }
    }

    sealed class SplashScreenState {
        object LoginSuccess : SplashScreenState()
        object LoginFailed : SplashScreenState()
    }

}