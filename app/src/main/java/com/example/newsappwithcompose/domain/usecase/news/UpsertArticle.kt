package com.example.newsappwithcompose.domain.usecase.news

import com.example.newsappwithcompose.data.local.NewsDao
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun  invoke(
        article: Article
    ){
        newsRepository.upsertArticle(article)
    }
}