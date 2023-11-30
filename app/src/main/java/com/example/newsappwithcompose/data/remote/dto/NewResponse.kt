package com.example.newsappwithcompose.data.remote.dto

import com.example.newsappwithcompose.domain.model.Article

data class NewResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)