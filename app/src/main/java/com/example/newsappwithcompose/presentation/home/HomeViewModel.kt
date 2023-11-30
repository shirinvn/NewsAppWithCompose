package com.example.newsappwithcompose.presentation.home

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsappwithcompose.domain.usecase.news.NewCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewCases
) : ViewModel(){
val news= newsUseCases.getNews(
    source = listOf("bbc-news", "abc-news", "al-jazeera-english")
).cachedIn(viewModelScope)

}