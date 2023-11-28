package com.example.newsappwithcompose.domain.manager

import kotlinx.coroutines.flow.Flow

class ReadAppEntry(

private val localUserManager: UserManager
){
    suspend operator fun invoke(): Flow<Boolean>{
      return  localUserManager.readAppEntry()
    }

}