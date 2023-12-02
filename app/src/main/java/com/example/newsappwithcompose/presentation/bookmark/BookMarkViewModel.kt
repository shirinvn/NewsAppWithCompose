package com.example.newsappwithcompose.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappwithcompose.domain.usecase.news.NewCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsCases: NewCases
) : ViewModel() {


    private val _state = mutableStateOf(BookMarkState())
     val state : State<BookMarkState> = _state

    init {
        getArticles()
    }
    private fun getArticles(){
        newsCases.selectArticles().onEach {
            _state.value = _state.value.copy(article = it)


        }.launchIn(viewModelScope)
    }
}