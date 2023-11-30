package com.example.newsappwithcompose.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsappwithcompose.R
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.domain.model.Source
import com.example.newsappwithcompose.presentation.Dimans.ArticleCardSize
import com.example.newsappwithcompose.presentation.Dimans.ExtraSmallPadding
import com.example.newsappwithcompose.presentation.Dimans.ExtraSmallPadding2
import com.example.newsappwithcompose.presentation.Dimans.SmallIconSize
import com.example.newsappwithcompose.ui.theme.NewsAppWithComposeTheme


@Composable
fun ArticalCard(
    modifier: Modifier =Modifier,
    article: Article,
    onClick:() -> Unit
){
    val context = LocalContext.current
    Row(
        modifier.clickable { onClick }
    ) {

        AsyncImage(modifier = Modifier
            .size(ArticleCardSize)
            .clip(MaterialTheme.shapes.medium)

            ,model = ImageRequest.Builder(context).data(article.urlToImage).build()
            , contentDescription =null)

        Column(verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)) {

            Text(text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            , maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Blue
                    , maxLines = 2,
                    overflow = TextOverflow.Ellipsis)

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
           Icon(painter = painterResource(id = R.drawable.ic_time),
               contentDescription = null,
               modifier = Modifier.size(SmallIconSize),
               tint = Color.Gray)

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Blue
                    , maxLines = 2,
                    overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticalCardPreview(){
    NewsAppWithComposeTheme {
        ArticalCard(article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = "2 hours",
            source = Source(id = "", name = "BBC"),
            title = "Her traint broke down, Her phone died. And then set her saver in a",
            url = "",
            urlToImage = ""
        )) {

        }
    }
}