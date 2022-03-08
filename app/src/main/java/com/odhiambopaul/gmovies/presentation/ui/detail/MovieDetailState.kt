package com.odhiambopaul.gmovies.presentation.ui.detail

import com.odhiambopaul.gmovies.domain.model.Movie

data class MovieDetailState(
    var isLoading: Boolean = false,
    var movie: Movie? = null,
    var error: String = ""
)