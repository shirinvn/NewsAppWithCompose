package com.example.newsappwithcompose.presentation.search

import androidx.paging.PagingData
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke (searchQuery: String, sources: List<String>):Flow<PagingData<Article>>{
        return  newsRepository.searchNews(searchQuery = searchQuery, sources =  sources)
    }
}