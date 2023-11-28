package com.example.newsappwithcompose.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsappwithcompose.R

data class Page(
   val title: String,
    val des : String,
    @DrawableRes val img: Int
)

val pages = listOf(
    Page(
        title = "hello 1",
        des = "hello i am shirin vatani, i have 26 years old",
        img = R.drawable.onboarding1
    ),
    Page(
        title = "hello 2",
        des = "ldfghdmvmi vmdivfji vdijfijifj ijvijgijgi slspdlfplccx ,ck",
        img = R.drawable.onboarding1
    ),
    Page(
        title = "hello 3",
        des = "kocvk okcosco sjcmskcmsk askakwkvof",
        img = R.drawable.onboarding1
    )
)
