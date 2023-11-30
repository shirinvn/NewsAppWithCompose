package com.example.newsappwithcompose.di

import android.app.Application
import com.example.newsappwithcompose.data.manager.LoaclUserManagerImpl
import com.example.newsappwithcompose.data.remote.NewsApi
import com.example.newsappwithcompose.data.repository.NewsRepositoryImp
import com.example.newsappwithcompose.domain.usecase.app_entry.AppEntryUseCases
import com.example.newsappwithcompose.domain.usecase.app_entry.ReadAppEntry
import com.example.newsappwithcompose.domain.usecase.app_entry.SaveAppEntry
import com.example.newsappwithcompose.domain.manager.UserManager
import com.example.newsappwithcompose.domain.repository.NewsRepository
import com.example.newsappwithcompose.domain.usecase.news.GetNews
import com.example.newsappwithcompose.domain.usecase.news.NewCases
import com.example.newsappwithcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent:: class)
object AppModule {

    @Provides
    fun provideLocalUserManager(
        application: Application
    ):UserManager = LoaclUserManagerImpl(application)


@Provides
@Singleton
fun provideEntryUseCases (
    localUserManager:UserManager
)= AppEntryUseCases(
    readAppEntry = ReadAppEntry(localUserManager =localUserManager ),
    saveAppEntry = SaveAppEntry(localUserManager)

    )


@Provides
@Singleton
fun provideNewsApi(): NewsApi{
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApi:: class.java)
}

@Provides
@Singleton
fun provideNewsRepository(newsApi: NewsApi)
: NewsRepository = NewsRepositoryImp(
    newsApi = newsApi
)

@Provides
@Singleton
fun provideNewsUseCases
            (newsRepository: NewsRepository)
: NewCases{
    return NewCases(
        getNews = GetNews(newsRepository =
        newsRepository)

    )
}
}