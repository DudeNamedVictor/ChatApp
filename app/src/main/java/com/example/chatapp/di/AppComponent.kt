package com.example.chatapp.di

import com.example.chatapp.data.repositories.AllChatsRepositoryImpl
import com.example.chatapp.data.services.ChatsServices
import com.example.chatapp.data.utils.BaseService
import com.example.chatapp.ui.allchats.AllChatsViewModel
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent {

    fun inject(viewModel: AllChatsViewModel)

}

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideChatsService(): BaseService {
        return BaseService()
    }

    @Provides
    @Singleton
    fun provideService(baseService: BaseService) = ChatsServices(baseService)

}

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideAllChats(chatsServices: ChatsServices): AllChatsRepositoryImpl {
        return AllChatsRepositoryImpl(chatsServices)
    }

}