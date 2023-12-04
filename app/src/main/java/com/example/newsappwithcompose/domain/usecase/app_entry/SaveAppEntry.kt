package com.example.newsappwithcompose.domain.usecase.app_entry

import com.example.newsappwithcompose.domain.manager.LocalUserManger
import com.example.newsappwithcompose.domain.manager.UserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}