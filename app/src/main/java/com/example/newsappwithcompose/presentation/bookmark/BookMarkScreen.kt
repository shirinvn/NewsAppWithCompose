package com.example.newsappwithcompose.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.newsappwithcompose.R
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.presentation.Dimans.MediumPadding
import com.example.newsappwithcompose.presentation.common.ArticleList
import com.example.newsappwithcompose.presentation.navgraph.Route

@Composable
fun BookMarkScreen(
    state: BookMarkState,
    navigateToDetails : (Article) -> Unit
) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                top = MediumPadding,
                start = MediumPadding,
                end = MediumPadding
            )
    ){
        Text(text = "BookMark",
            style = MaterialTheme.typography.displayMedium
                .copy(fontWeight = FontWeight.Bold),
            color= colorResource(id = R.color.text_title))

        Spacer(modifier = Modifier.height(MediumPadding))

        ArticleList(article = state.article, onClick =
        {navigateToDetails(it)})
    }
}