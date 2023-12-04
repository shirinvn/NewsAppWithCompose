package com.example.newsappwithcompose.di

import android.app.Application
import androidx.room.Room
import com.example.newsappwithcompose.data.local.NewsDao
import com.example.newsappwithcompose.data.local.NewsDataBase
import com.example.newsappwithcompose.data.local.NewsTypeConvertor
import com.example.newsappwithcompose.data.manager.NewsConnectivityManger
import com.example.newsappwithcompose.data.remote.NewsApi
import com.example.newsappwithcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDataBase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDataBase
    ): NewsDao = newsDatabase.newsDao

    @Provides
    @Singleton
    fun provideConnectivityManager(
        application: Application
    ) = NewsConnectivityManger(application)

}