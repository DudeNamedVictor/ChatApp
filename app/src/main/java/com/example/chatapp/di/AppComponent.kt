package com.example.chatapp.di

import com.example.chatapp.data.services.ChatsServices
import com.example.chatapp.data.utils.BaseService
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {



}

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideChatsService(): BaseService {
        return BaseService()
    }

    @Provides
    @Singleton
    fun provideService(baseService: BaseService) = ChatsServices(baseService)

}