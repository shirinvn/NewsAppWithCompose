package com.example.newsappwithcompose.presentation.details

import com.example.newsappwithcompose.domain.model.Article


sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}