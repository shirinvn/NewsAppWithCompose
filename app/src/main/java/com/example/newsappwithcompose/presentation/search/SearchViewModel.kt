package com.example.newsappwithcompose.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappwithcompose.domain.usecase.news.NewCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewCases
)  : ViewModel() {


    private val _state= mutableStateOf(SearchState())
    val state: State<SearchState> = _state
    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery-> {
                _state.value= state.value.copy(event.searchQuery)

            }
            is SearchEvent.SearchNews -> {
                searchNews()
            }
        }
    }


    private fun searchNews(){
        val article  = newsUseCases.searchNews(
            searechQuery = state.value.searchQuery,
            sources =listOf("bbc-news", "abc-news", "al-jazeera-english")
        ).cachedIn(viewModelScope)
        _state.value= state.value.copy(article)
    }
}