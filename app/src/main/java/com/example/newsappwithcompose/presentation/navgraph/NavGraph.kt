package com.example.newsappwithcompose.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.newsappwithcompose.data.manager.NewsConnectivityManger
import com.example.newsappwithcompose.presentation.newsnavigator.NewsNavigator
import com.example.newsappwithcompose.presentation.onboarding.OnBoardingScreen
import com.example.newsappwithcompose.presentation.onboarding.OnBoardingViewModel



@Composable
fun NavGraph(
    startDestination: String,
    newsConnectivityManger: NewsConnectivityManger
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route){
                NewsNavigator(
                    newsConnectivityManger
                )
            }
        }
    }
}