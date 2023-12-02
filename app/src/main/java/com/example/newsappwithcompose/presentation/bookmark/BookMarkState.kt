package com.example.newsappwithcompose.presentation.bookmark

import com.example.newsappwithcompose.domain.model.Article

data class BookMarkState(
    val article: List<Article> = emptyList()
)
