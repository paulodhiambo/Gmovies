package com.odhiambopaul.gmovies.presentation.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odhiambopaul.gmovies.common.Resource
import com.odhiambopaul.gmovies.domain.usecases.GetPopularMoviesUseCase
import com.odhiambopaul.gmovies.domain.usecases.GetTopRatedMoviesUseCase
import com.odhiambopaul.gmovies.domain.usecases.GetUpcomingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    private val _popularMovieState = mutableStateOf(PopularMoviesState())
    val popularMovieState: State<PopularMoviesState> = _popularMovieState

    private val _upComingMovieState = mutableStateOf(UpComingMoviesState())
    val upComingMoviesState: State<UpComingMoviesState> = _upComingMovieState

    private val _topRatedMovieState = mutableStateOf(TopRatedMoviesState())
    val topRatedMoviesState: State<TopRatedMoviesState> = _topRatedMovieState

    init {
        getTopRatedMovies()
        getPopularMovies()
        getUpComingMovies()
    }

    private fun getPopularMovies() {
        getPopularMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _popularMovieState.value =
                        PopularMoviesState(movies = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _popularMovieState.value = PopularMoviesState(isLoading = true)
                }
                is Resource.Error -> {
                    _popularMovieState.value = PopularMoviesState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getUpComingMovies() {
        getUpcomingMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _upComingMovieState.value =
                        UpComingMoviesState(movies = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _upComingMovieState.value = UpComingMoviesState(isLoading = true)
                }
                is Resource.Error -> {
                    _upComingMovieState.value = UpComingMoviesState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getTopRatedMovies() {
        getTopRatedMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _topRatedMovieState.value =
                        TopRatedMoviesState(movies = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _topRatedMovieState.value = TopRatedMoviesState(isLoading = true)
                }
                is Resource.Error -> {
                    _topRatedMovieState.value = TopRatedMoviesState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}