package com.example.newsappwithcompose.presentation.onboarding.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.decode.ImageSource
import com.example.newsappwithcompose.R
import com.example.newsappwithcompose.presentation.Dimans.MediumPadding
import com.example.newsappwithcompose.presentation.Dimans.MediumPadding2
import com.example.newsappwithcompose.presentation.onboarding.Page
import com.example.newsappwithcompose.presentation.onboarding.pages
import com.example.newsappwithcompose.ui.theme.NewsAppWithComposeTheme
import org.w3c.dom.Text

@Composable
fun OnBoardingPage(
    modifier :Modifier= Modifier,
    page: Page

){

    Column (modifier= modifier){
        Image(painter = painterResource(id = page.img), 
            contentDescription =null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f))
    }
    Spacer(modifier = Modifier.height(MediumPadding))
    Text(text= page.title, modifier
        .padding(horizontal = MediumPadding2),
        style= MaterialTheme.typography.displaySmall
            .copy(fontWeight = FontWeight.Bold),
        color = colorResource(id = R.color.purple_200) )


    Text(text= page.des, modifier
        .padding(horizontal = MediumPadding2),
        style= MaterialTheme.typography.displaySmall
            .copy(fontWeight = FontWeight.Bold),
        color = colorResource(id = R.color.purple_700) )
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    NewsAppWithComposeTheme {
        OnBoardingPage(page =
            pages[0]
        )
    }
}
