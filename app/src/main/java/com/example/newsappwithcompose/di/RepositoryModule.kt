package com.example.newsappwithcompose.di

import com.example.newsappwithcompose.data.repository.NewsRepositoryImp
import com.example.newsappwithcompose.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImp): NewsRepository

}