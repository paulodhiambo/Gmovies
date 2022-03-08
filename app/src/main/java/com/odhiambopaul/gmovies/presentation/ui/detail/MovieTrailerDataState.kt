package com.odhiambopaul.gmovies.presentation.ui.detail

import com.odhiambopaul.gmovies.domain.model.MovieTrailer

data class MovieTrailerDataState(
    var isLoading: Boolean = false,
    var trailer: MovieTrailer? = null,
    var error: String = ""
)