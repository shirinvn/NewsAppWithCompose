package com.example.newsappwithcompose.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.domain.usecase.news.NewCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
                viewModelScope.launch {
                    val article = newsCases.selectArticle(event.article.url)

                    if (article== null) {
                        updateArticle(event.article)
                    }else{
                        deleteArticle(event.article)
                    }
                }
            }
            is DetailEvent.RemoveSideEffect -> {
                sideEffect =null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsCases.upsertArticle(article)
        sideEffect= "Article Saved"


    }

    private  suspend fun updateArticle(article: Article) {
        newsCases.upsertArticle(article)
        sideEffect= "Article Deleted"

    }


}