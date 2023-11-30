package com.example.newsappwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.newsappwithcompose.domain.usecase.app_entry.AppEntryUseCases
import com.example.newsappwithcompose.presentation.navgraph.NavGraph
import com.example.newsappwithcompose.ui.theme.NewsAppWithComposeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel> ()
    @Inject
    lateinit var usecases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }

        }



        setContent {
            NewsAppWithComposeTheme {
                val usSystemDarkMode= isSystemInDarkTheme()
                val systemController= rememberSystemUiController()

                SideEffect {

                    systemController.setStatusBarColor(
                        color = Color.Transparent,
                        darkIcons = false
                    )
                }
                   Box(modifier = Modifier.background(MaterialTheme.colorScheme.background))
                val startDestination = viewModel.startDestination

                NavGraph(startDestination =startDestination )

            }
        }
    }
}

