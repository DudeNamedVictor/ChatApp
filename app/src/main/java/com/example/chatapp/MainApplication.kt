package com.example.chatapp

import android.app.Application
import com.example.chatapp.di.AppComponent
import com.example.chatapp.di.DaggerAppComponent

class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}