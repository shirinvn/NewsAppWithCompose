package com.example.newsappwithcompose.presentation.home

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.newsappwithcompose.R
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.presentation.Dimans.MediumPadding
import com.example.newsappwithcompose.presentation.common.ArticleList
import com.example.newsappwithcompose.presentation.common.SearchBar
import com.example.newsappwithcompose.presentation.navgraph.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    article: LazyPagingItems<Article>, navigate: (String)-> Unit
){
    val titles by remember {
        derivedStateOf {
            if (article.itemCount >10){
                article.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString (separator = " \uD83d\uDFE5 "){it.title}

            }else
            {
                ""
            }
        }
    }
    Column (modifier = Modifier
        .padding(top = MediumPadding)
        .fillMaxSize()
        .statusBarsPadding()){

        Image(painter = painterResource(
            id = R.drawable.ic_logo),
            contentDescription =null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding))

        Spacer(modifier = Modifier.height(MediumPadding))

        SearchBar(modifier = Modifier.padding(horizontal = MediumPadding)
            ,text =""
            , readOnly =true
            , onValueChange ={},
            onSearch = {

            },
            onClick = {
                navigate(Route.SearchScreen.route)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding))

        Text(text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)

        )

        Spacer(modifier = Modifier.height(MediumPadding))

        ArticleList(modifier = Modifier.padding(horizontal = MediumPadding)
            ,
            article = article,
            onClick = {
                navigate(Route.DetailScreen.route)
            })

    }

}