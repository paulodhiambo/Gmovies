package com.odhiambopaul.gmovies.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.odhiambopaul.gmovies.presentation.theme.GmoviesTheme
import com.odhiambopaul.gmovies.presentation.ui.detail.MovieDetailScreen
import com.odhiambopaul.gmovies.presentation.ui.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmoviesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MovieListScreen.route
                    ) {
                        composable(route = Screen.MovieListScreen.route) {
                            HomeScreen(navController)
                        }

                        composable(route = Screen.MovieDetailScreen.route + "/{movie_id}") {
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}