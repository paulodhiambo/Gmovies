package com.odhiambopaul.gmovies.presentation.ui.home

import com.odhiambopaul.gmovies.domain.model.Movie

data class UpComingMoviesState(
    var isLoading: Boolean = false,
    var movies: List<Movie?> = emptyList(),
    var error: String = ""
)