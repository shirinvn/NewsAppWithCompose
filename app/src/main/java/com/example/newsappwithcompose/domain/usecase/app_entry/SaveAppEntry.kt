package com.example.newsappwithcompose.domain.usecase.app_entry

import com.example.newsappwithcompose.domain.manager.UserManager

class SaveAppEntry(
    private val localUserManager: UserManager
){
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}