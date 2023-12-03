package com.example.newsappwithcompose.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.newsappwithcompose.domain.usecase.news.NewCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsCases: NewCases
): ViewModel() {



    var sideEffect by mutableStateOf<String?>( null)
    private  set


    fun onEvent(event: DetailEvent){
        when(event){
            is DetailEvent.UpsertDeleteArticle-> {
            }
        }
    }


}