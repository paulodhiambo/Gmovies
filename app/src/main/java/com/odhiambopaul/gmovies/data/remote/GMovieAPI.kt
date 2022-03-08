package com.odhiambopaul.gmovies.data.remote

import com.odhiambopaul.gmovies.data.remote.dto.MovieDetailsResponse
import com.odhiambopaul.gmovies.data.remote.dto.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GMovieAPI {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): MoviesResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesResponse

    @GET("movie/upcoming")
    suspend fun getUpComingMovies(): MoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): MovieDetailsResponse
}