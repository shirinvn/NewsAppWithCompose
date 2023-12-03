package com.example.newsappwithcompose.domain.usecase

import com.example.newsappwithcompose.data.local.NewsDao
import com.example.newsappwithcompose.domain.model.Article

class SelectAritcle(

private val newsDao: NewsDao
) {

    suspend operator fun  invoke(url: String): Article?{
     return   newsDao.getArticle(url)
    }
}