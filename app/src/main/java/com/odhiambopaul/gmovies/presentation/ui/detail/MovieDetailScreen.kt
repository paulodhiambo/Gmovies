package com.odhiambopaul.gmovies.presentation.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.odhiambopaul.gmovies.presentation.ui.detail.components.MovieDetailHeader
import com.odhiambopaul.gmovies.presentation.ui.detail.components.MovieDetailSummary

@Composable
fun MovieDetailScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.movieDetailState.value
    if (state.movie != null) {
        Column() {
            MovieDetailHeader()
            MovieDetailSummary()
        }
    }
}
