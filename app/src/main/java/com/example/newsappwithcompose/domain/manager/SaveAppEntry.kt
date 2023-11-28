package com.example.newsappwithcompose.domain.manager

class SaveAppEntry(
    private val localUserManager: UserManager
){
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}