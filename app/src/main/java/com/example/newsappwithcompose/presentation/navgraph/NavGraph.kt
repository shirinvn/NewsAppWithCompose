package com.example.newsappwithcompose.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsappwithcompose.presentation.home.HomeScreen
import com.example.newsappwithcompose.presentation.home.HomeViewModel
import com.example.newsappwithcompose.presentation.onboarding.OnBoardingScreen
import com.example.newsappwithcompose.presentation.onboarding.OnBoardingViewModel
import kotlinx.coroutines.flow.collectIndexed

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()
    NavHost(navController =navController
        , startDestination = startDestination){

        navigation(
            route=Route.AppStartingNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route= Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)

            }
        }
        navigation(
            route= Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        ){
            composable(route= Route.NewsNavigationScreen.route){

                val viewMOdel:HomeViewModel= hiltViewModel()
                val articles= viewMOdel.news.collectAsLazyPagingItems()
                HomeScreen(article = articles, navigate = {})
            }
        }
    }



}