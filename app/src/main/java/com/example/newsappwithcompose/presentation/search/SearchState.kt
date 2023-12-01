package com.example.newsappwithcompose.presentation.search

import com.example.newsappwithcompose.domain.model.Article

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow


data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)