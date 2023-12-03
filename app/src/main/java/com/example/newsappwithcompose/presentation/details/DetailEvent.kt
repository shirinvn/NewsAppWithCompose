package com.example.newsappwithcompose.presentation.details

import com.example.newsappwithcompose.domain.model.Article

sealed class DetailEvent {


    data class UpsertDeleteArticle (val article: Article): DetailEvent()

    object RemoveSideEffect : DetailEvent()
}