package com.example.newsappwithcompose.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.presentation.Dimans.ExtraSmallPadding2
import com.example.newsappwithcompose.presentation.Dimans.MediumPadding


@Composable
fun ArticleList(
    modifier: Modifier=Modifier,
    article: List<Article>,
    onClick:(Article) -> Unit
){

        LazyColumn(modifier= modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ){
            items(count = article.size){
              val article=   article[it]
                    ArticalCard(article = article, onClick = {onClick(article)})
                }
            }
        }


@Composable
fun ArticleList(
    modifier: Modifier=Modifier,
    article: LazyPagingItems<Article>,
    onClick:(Article) -> Unit
){
    val handlePagingresult = handlePagingResult(article = article)
    if (handlePagingresult){
        LazyColumn(modifier= modifier.fillMaxSize(),
           verticalArrangement = Arrangement.spacedBy(MediumPadding),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ){
            items(count = article.itemCount){
                article[it]?.let{
                    ArticalCard(article = it, onClick = {onClick(it)})
                }
            }
        }
    }

}
@Composable
fun handlePagingResult(
    article: LazyPagingItems<Article>,

    ): Boolean {
    val loadState = article.loadState
    val error= when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
   else -> null
    }
    return when
    {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }
        error != null -> {
            EmptyScreen()
            false
        }
        else
            -> true
    }
}

@Composable
private fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding)){
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding)
            )
        }
    }
}