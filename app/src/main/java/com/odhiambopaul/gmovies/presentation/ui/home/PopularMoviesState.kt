package com.odhiambopaul.gmovies.presentation.ui.home

import com.odhiambopaul.gmovies.domain.model.Movie

data class PopularMoviesState(
    var isLoading: Boolean = false,
    var movies: List<Movie?> = emptyList(),
    var error: String = ""
)