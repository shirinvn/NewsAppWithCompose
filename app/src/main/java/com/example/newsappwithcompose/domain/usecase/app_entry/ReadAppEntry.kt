package com.example.newsappwithcompose.domain.usecase.app_entry

import com.example.newsappwithcompose.domain.manager.LocalUserManger
import com.example.newsappwithcompose.domain.manager.UserManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ReadAppEntry @Inject constructor(
private val localUserManger: LocalUserManger
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}