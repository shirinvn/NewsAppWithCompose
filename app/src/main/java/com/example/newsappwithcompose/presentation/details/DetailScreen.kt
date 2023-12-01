package com.example.newsappwithcompose.presentation.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsappwithcompose.R
import com.example.newsappwithcompose.domain.model.Article
import com.example.newsappwithcompose.presentation.Dimans.ArticleImageHeight
import com.example.newsappwithcompose.presentation.Dimans.MediumPadding
import com.example.newsappwithcompose.presentation.details.components.DetailTopBar
import com.example.newsappwithcompose.presentation.navgraph.Route


@Composable
fun DetailScreen (
    article: Article,
    event: (DetailEvent) -> Unit,
    navigateUp : () ->Unit
) {


    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        DetailTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClicks = { event(DetailEvent.SaveArticle) },
            onBackClicks = navigateUp
        )
        LazyColumn(
            modifier=Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding,
                end = MediumPadding,
                top = MediumPadding
            )
        ){
            item {
                AsyncImage(model = ImageRequest.Builder(
                    context = context
                ).data(article.urlToImage).build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop)

                Spacer(modifier = Modifier.height(MediumPadding))

                Text(text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color= colorResource(id = R.color.text_title))

                Text(text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color= colorResource(id = R.color.body))

            }

        }

    }
}