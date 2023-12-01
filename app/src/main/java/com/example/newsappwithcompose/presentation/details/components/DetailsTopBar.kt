package com.example.newsappwithcompose.presentation.details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsappwithcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(
    onBrowsingClick: () -> Unit
    , onShareClick: () -> Unit
    , onBookmarkClicks: () -> Unit
    , onBackClicks: () -> Unit

){

    TopAppBar(title = {},
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor =
            colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body),

        ),
        navigationIcon = {
            IconButton(onClick = onBackClicks) {
                Icon(painter = painterResource(
                    id = R.drawable.ic_back_arrow),
                    contentDescription = null)

            }
        },
        actions = {
            IconButton(onClick = onBookmarkClicks) {
                Icon(painter = painterResource
                    (id = R.drawable.ic_bookmark),
                    contentDescription = null)
            }
            IconButton(onClick = onShareClick) {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = null)

            }
            IconButton(onClick = onBrowsingClick) {
                Icon(painter = painterResource(id = R.drawable.ic_network),
                    contentDescription = null)

            }
        })
}

