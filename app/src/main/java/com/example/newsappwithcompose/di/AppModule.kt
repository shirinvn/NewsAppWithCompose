package com.example.newsappwithcompose.di

import android.app.Application
import com.example.newsappwithcompose.data.manager.LoaclUserManagerImpl
import com.example.newsappwithcompose.domain.manager.AppEntryUseCases
import com.example.newsappwithcompose.domain.manager.ReadAppEntry
import com.example.newsappwithcompose.domain.manager.SaveAppEntry
import com.example.newsappwithcompose.domain.manager.UserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent:: class)
object AppModule {

    @Provides
    fun provideLocalUserManager(
        application: Application
    ):UserManager = LoaclUserManagerImpl(application)
}

@Provides
@Singleton
fun provideEntryUseCases (
    localUserManager:UserManager
)= AppEntryUseCases(
    readAppEntry = ReadAppEntry(localUserManager =localUserManager ),
    saveAppEntry = SaveAppEntry(localUserManager)

    )