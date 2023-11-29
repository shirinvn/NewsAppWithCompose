package com.example.newsappwithcompose.presentation.navgraph

sealed class Route(
    val route: String
){
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "HomeScreen")
    object SearchScreen : Route(route = "SearchScreen")
    object BookMarkScreen : Route(route = "BookMarkScreen")
    object DetailScreen : Route(route = "DetailScreen")
    object NewsNavigation : Route(route = "NewsNavigation")
    object NewsNavigationScreen : Route(route = "NewsNavigationScreen")
    object AppStartingNavigation : Route(route = "AppStartingNavigation")

}
