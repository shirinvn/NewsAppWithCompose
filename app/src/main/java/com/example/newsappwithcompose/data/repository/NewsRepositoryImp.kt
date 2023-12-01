package com.example.newsappwithcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsappwithcompose.data.remote.NewsApi
import com.example.newsappwithcompose.data.remote.NewsPagingSource
import com.example.newsappwithcompose.data.remote.SearchNewsPagingSource
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp (
    private val newsApi :NewsApi
): NewsRepository{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
       return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    soruce = sources.joinToString(separator = ",")
                )
            }
       ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery
                    ,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow    }

}