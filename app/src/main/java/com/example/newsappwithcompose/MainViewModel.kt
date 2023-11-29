package com.example.newsappwithcompose

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappwithcompose.domain.manager.AppEntryUseCases
import com.example.newsappwithcompose.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val appEntryUseCases: AppEntryUseCases
) : ViewModel(){

     var splashCondition by mutableStateOf(true)
    private set

    var startDestination by mutableStateOf(Route.AppStartingNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach {
           if (it){
               startDestination= Route.NewsNavigation.route
           }else{
               startDestination= Route.AppStartingNavigation.route
           }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}