package com.example.newsappwithcompose.di

import com.example.newsappwithcompose.data.manager.LocalUserMangerImpl
import com.example.newsappwithcompose.domain.manager.LocalUserManger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class MangerModule {

    @Binds
    @Singleton
    abstract fun bindLocalUserManger(localUserMangerImpl: LocalUserMangerImpl) : LocalUserManger
}