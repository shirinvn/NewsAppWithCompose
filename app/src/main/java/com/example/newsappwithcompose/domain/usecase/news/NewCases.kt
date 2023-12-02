package com.example.newsappwithcompose.domain.usecase.news

import com.example.newsappwithcompose.presentation.search.SearchEvent
import com.example.newsappwithcompose.presentation.search.SearchNews

data class NewCases(
    val getNews :GetNews,
    val searchNews : SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles
)
