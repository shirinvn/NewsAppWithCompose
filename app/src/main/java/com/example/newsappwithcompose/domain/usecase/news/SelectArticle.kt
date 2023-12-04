package com.example.newsappwithcompose.domain.usecase.news

import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.domain.repository.NewsRepository

class SelectArticle (


    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticle(url)
    }
}