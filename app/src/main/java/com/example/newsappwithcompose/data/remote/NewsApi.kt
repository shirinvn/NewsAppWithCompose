package com.example.newsappwithcompose.data.remote

import com.example.newsappwithcompose.data.remote.dto.NewResponse
import com.example.newsappwithcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") source : String,
        @Query("apiKey") apiKey: String= API_KEY
    ): NewResponse
}