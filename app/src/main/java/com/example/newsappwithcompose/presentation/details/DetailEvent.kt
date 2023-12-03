package com.example.newsappwithcompose.presentation.details

sealed class DetailEvent {


    object UpsertDeleteArticle : DetailEvent()

    object RemoveSideEffect : DetailEvent()
}