package com.example.newsappwithcompose.domain.usecase.news

import androidx.paging.PagingData
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}