package com.example.newsappwithcompose.presentation.search

import com.example.newsappwithcompose.domain.model.Article
import java.util.concurrent.Flow

import androidx.paging.PagingData


data class SearchState(
    val searchQuery: String = "",
    val articles: kotlinx.coroutines.flow.Flow<PagingData<Article>>? = null
)