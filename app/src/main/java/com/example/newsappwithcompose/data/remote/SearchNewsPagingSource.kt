package com.example.newsappwithcompose.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsappwithcompose.domain.model.Article
import java.lang.Exception

class SearchNewsPagingSource(
    private val newsApi : NewsApi,
    private val searchQuery : String,
    private val sources: String
): PagingSource<Int,Article>() {

    private var totalNewaCount = 0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

            val page= params.key?: 1
            return try {

                val newsResponce=newsApi.searchNews(searchQuery = searchQuery,source = sources,
                    page = page )
                totalNewaCount += newsResponce.articles.size
                val article = newsResponce.articles.distinctBy {
                    it.title
                }
                LoadResult.Page(
                    data = article,
                    nextKey = if (totalNewaCount == newsResponce.totalResults ) null else page +1,
                    prevKey = null
                )
            }catch (e: Exception){
                e.printStackTrace()
                LoadResult.Error(
                    throwable = e
                )
            }
    }
}