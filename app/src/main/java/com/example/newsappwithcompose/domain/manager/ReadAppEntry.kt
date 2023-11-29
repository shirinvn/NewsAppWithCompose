package com.example.newsappwithcompose.domain.manager

import kotlinx.coroutines.flow.Flow

class ReadAppEntry(

private val localUserManager: UserManager
){
     operator fun invoke(): Flow<Boolean>{
      return  localUserManager.readAppEntry()
    }

}