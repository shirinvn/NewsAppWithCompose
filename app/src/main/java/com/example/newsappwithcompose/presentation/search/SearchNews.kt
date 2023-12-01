package com.example.newsappwithcompose.presentation.search

import androidx.paging.PagingData
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.domain.repository.NewsRepository
import java.util.concurrent.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke (searechQuery:String, sources: List<String>): kotlinx.coroutines.flow.Flow<PagingData<Article>>{
        return  newsRepository.searchNews(searechQuery, sources)
    }
}