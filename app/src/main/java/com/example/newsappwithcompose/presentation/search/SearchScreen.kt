package com.example.newsappwithcompose.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.presentation.Dimans.MediumPadding
import com.example.newsappwithcompose.presentation.common.ArticleList
import com.example.newsappwithcompose.presentation.common.SearchBar


@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails : (Article) -> Unit
){

    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding,
                start = MediumPadding,
                end = MediumPadding
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(text =state.searchQuery
            , readOnly =false
            , onValueChange ={event(SearchEvent.UpdateSearchQuery(it))},
            onSearch = {event(SearchEvent.SearchNews)}
        )

        Spacer(modifier = Modifier.height(MediumPadding))
        state.articles?.let {
            val article= it.collectAsLazyPagingItems()
            ArticleList(article = article, onClick = {navigateToDetails(it)
            })
        }
    }
}
