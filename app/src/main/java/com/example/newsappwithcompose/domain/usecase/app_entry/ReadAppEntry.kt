package com.example.newsappwithcompose.domain.usecase.app_entry

import com.example.newsappwithcompose.domain.manager.UserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(

private val localUserManager: UserManager
){
     operator fun invoke(): Flow<Boolean>{
      return  localUserManager.readAppEntry()
    }

}