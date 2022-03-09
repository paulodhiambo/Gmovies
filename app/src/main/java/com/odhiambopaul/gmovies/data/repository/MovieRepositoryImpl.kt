package com.odhiambopaul.gmovies.data.repository

import com.odhiambopaul.gmovies.common.MovieTypes
import com.odhiambopaul.gmovies.data.local.MovieDao
import com.odhiambopaul.gmovies.data.remote.GMovieAPI
import com.odhiambopaul.gmovies.data.remote.dto.MovieDetailsResponse
import com.odhiambopaul.gmovies.data.remote.dto.MoviesResponse
import com.odhiambopaul.gmovies.domain.model.Movie
import com.odhiambopaul.gmovies.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: GMovieAPI,
    private val movieDao: MovieDao
) : MovieRepository {
    override suspend fun getPopularMovies(): MoviesResponse = api.getPopularMovies()

    override suspend fun getTopRatedMovies(): MoviesResponse = api.getTopRatedMovies()

    override suspend fun getUpComingMovies(): MoviesResponse = api.getUpComingMovies()

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse =
        api.getMovieDetails(movieId)

    override suspend fun getLocalMovies(movieTypes: MovieTypes): List<Movie> =
        movieDao.getMovies(movieTypes)

    override suspend fun saveMovieLocally(movie: Movie) = movieDao.saveMovie(movie)

    override suspend fun getLocalMovieById(id: Int): Movie = movieDao.getMovieById(id)
}