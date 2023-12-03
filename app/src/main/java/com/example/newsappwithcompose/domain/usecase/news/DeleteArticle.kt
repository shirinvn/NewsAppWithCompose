package com.example.newsappwithcompose.domain.usecase.news

import com.example.newsappwithcompose.data.local.NewsDao
import com.example.newsappwithcompose.domain.model.Article

class DeleteArticle (


    private val newsDao: NewsDao
    ) {

        suspend operator fun  invoke(
            article: Article
        ){
            newsDao.delete(article)
        }
    }
