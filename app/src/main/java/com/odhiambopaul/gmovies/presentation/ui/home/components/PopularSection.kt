package com.odhiambopaul.gmovies.presentation.ui.home.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.odhiambopaul.gmovies.presentation.Screen
import com.odhiambopaul.gmovies.presentation.ui.home.HomeViewModel

@ExperimentalMaterialApi
@Composable
fun PopularSection(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.popularMovieState.value
    LazyRow {
        items(state.movies.size) {
            state.movies[it]?.let { movie ->
                MovieCard(
                    movie = movie,
                    onMovieClick = { navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}") })
            }
        }
    }
}