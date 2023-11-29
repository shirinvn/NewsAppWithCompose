package com.example.newsappwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.newsappwithcompose.domain.manager.AppEntryUseCases
import com.example.newsappwithcompose.presentation.navgraph.NavGraph
import com.example.newsappwithcompose.presentation.onboarding.OnBoardingScreen
import com.example.newsappwithcompose.presentation.onboarding.OnBoardingViewModel
import com.example.newsappwithcompose.ui.theme.NewsAppWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
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
                   Box(modifier = Modifier.background(MaterialTheme.colorScheme.background))
                val startDestination = viewModel.startDestination

                NavGraph(startDestination =startDestination )

            }
        }
    }
}

