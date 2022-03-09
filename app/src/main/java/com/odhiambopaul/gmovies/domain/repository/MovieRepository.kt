package com.odhiambopaul.gmovies.domain.repository

import com.odhiambopaul.gmovies.common.MovieTypes
import com.odhiambopaul.gmovies.data.remote.dto.MovieDetailsResponse
import com.odhiambopaul.gmovies.data.remote.dto.MoviesResponse
import com.odhiambopaul.gmovies.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): MoviesResponse

    suspend fun getTopRatedMovies(): MoviesResponse

    suspend fun getUpComingMovies(): MoviesResponse

    suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse

    suspend fun getLocalMovies(movieTypes: MovieTypes): List<Movie>

    suspend fun saveMovieLocally(movie: Movie)

    suspend fun getLocalMovieById(id: Int): Movie

}