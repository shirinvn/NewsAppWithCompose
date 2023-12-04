package com.example.newsappwithcompose.presentation.bookmark



import com.example.newsappwithcompose.domain.model.Article
data class BookmarkState(
    val articles: List<Article> = emptyList()
)