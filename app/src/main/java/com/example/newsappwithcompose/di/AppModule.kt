package com.example.newsappwithcompose.di

import android.app.Application
import androidx.room.Room
import com.example.newsappwithcompose.data.local.NewsDao
import com.example.newsappwithcompose.data.local.NewsDataBase
import com.example.newsappwithcompose.data.local.NewsTypeConvertor
import com.example.newsappwithcompose.data.manager.LoaclUserManagerImpl
import com.example.newsappwithcompose.data.remote.NewsApi
import com.example.newsappwithcompose.data.repository.NewsRepositoryImp
import com.example.newsappwithcompose.domain.usecase.app_entry.AppEntryUseCases
import com.example.newsappwithcompose.domain.usecase.app_entry.ReadAppEntry
import com.example.newsappwithcompose.domain.usecase.app_entry.SaveAppEntry
import com.example.newsappwithcompose.domain.manager.UserManager
import com.example.newsappwithcompose.domain.repository.NewsRepository
import com.example.newsappwithcompose.domain.usecase.news.DeleteArticle
import com.example.newsappwithcompose.domain.usecase.news.GetNews
import com.example.newsappwithcompose.domain.usecase.news.NewCases
import com.example.newsappwithcompose.domain.usecase.news.SelectArticle
import com.example.newsappwithcompose.domain.usecase.news.SelectArticles
import com.example.newsappwithcompose.domain.usecase.news.UpsertArticle
import com.example.newsappwithcompose.presentation.search.SearchNews
import com.example.newsappwithcompose.util.Constants.BASE_URL
import com.example.newsappwithcompose.util.Constants.DATA_BASE_NAME
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
fun provideNewsRepository(newsApi: NewsApi,
                          newsDao: NewsDao)
: NewsRepository = NewsRepositoryImp(
    newsApi = newsApi, newsDao = newsDao
)

@Provides
@Singleton
fun provideNewsUseCases
            (newsRepository: NewsRepository,
             newsDao: NewsDao)
: NewCases{
    return NewCases(
        getNews = GetNews(newsRepository =
        newsRepository),
        searchNews = SearchNews(newsRepository),
        upsertArticle = UpsertArticle(newsRepository),
        deleteArticle = DeleteArticle(newsRepository),
        selectArticles = SelectArticles(newsRepository),
        selectArticle = SelectArticle(newsRepository)

    )
}

    @Provides
    @Singleton
    fun provideNewsDataBase(
        application: Application
    ):NewsDataBase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDataBase::class.java,
            name = DATA_BASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun  provideNewsDao(
        newsDataBase: NewsDataBase
    ): NewsDao = newsDataBase.newsDao
}