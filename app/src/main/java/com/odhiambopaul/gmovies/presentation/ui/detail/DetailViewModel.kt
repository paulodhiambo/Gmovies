package com.odhiambopaul.gmovies.presentation.ui.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odhiambopaul.gmovies.common.Constants.PARAM_MOVIE_ID
import com.odhiambopaul.gmovies.common.Resource
import com.odhiambopaul.gmovies.domain.usecases.GetMovieDetailUseCase
import com.odhiambopaul.gmovies.domain.usecases.GetMovieTrailerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getMovieTrailerUseCase: GetMovieTrailerUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _movieDetailState = mutableStateOf(MovieDetailState())
    val movieDetailState: State<MovieDetailState> = _movieDetailState

    private val _movieTrailerDataState = mutableStateOf(MovieTrailerDataState())
    val movieTrailerDataState: State<MovieTrailerDataState> = _movieTrailerDataState

    init {
        savedStateHandle.get<String>(PARAM_MOVIE_ID)?.let { movieId ->
            getMovieDetails(movieId.toInt())
            getMovieTrailer(movieId.toInt())
        }
    }

    private fun getMovieDetails(id: Int) {
        getMovieDetailUseCase(id = id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _movieDetailState.value = MovieDetailState(movie = result.data)
                }
                is Resource.Loading -> {
                    _movieDetailState.value = MovieDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _movieDetailState.value = MovieDetailState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMovieTrailer(id: Int) {
        getMovieTrailerUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _movieTrailerDataState.value = MovieTrailerDataState(trailer = result.data)
                }
                is Resource.Loading -> {
                    _movieTrailerDataState.value = MovieTrailerDataState(isLoading = true)
                }
                is Resource.Error -> {
                    _movieTrailerDataState.value = MovieTrailerDataState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}