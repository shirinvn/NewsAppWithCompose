package com.example.newsappwithcompose.domain.usecase.news

import com.example.newsappwithcompose.data.local.NewsDao
import com.example.newsappwithcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles
    (
    private val newsDao: NewsDao
) {

     operator fun  invoke(

    ) : Flow<List<Article>>{
      return  newsDao.getArticles()
    }
}
