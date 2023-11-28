package com.example.newsappwithcompose.domain.manager

import java.util.concurrent.Flow

interface UserManager {
    suspend fun saveAppEntry()

    fun readAppEntry() : kotlinx.coroutines.flow.Flow<Boolean>
}