package com.odhiambopaul.gmovies.domain.usecases

import com.odhiambopaul.gmovies.common.MovieTypes
import com.odhiambopaul.gmovies.common.Resource
import com.odhiambopaul.gmovies.data.remote.dto.toMovie
import com.odhiambopaul.gmovies.domain.model.Movie
import com.odhiambopaul.gmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            repository.getUpComingMovies()
                .moviesDtos.forEach { repository.saveMovieLocally(it.toMovie(MovieTypes.UPCOMING)) }
            val movies = repository.getLocalMovies(MovieTypes.UPCOMING)
            emit(Resource.Success(movies))

        } catch (e: HttpException) {
            //On network error, fallback to the local database
            val movies = repository.getLocalMovies(MovieTypes.UPCOMING)
            emit(Resource.Success(movies))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }
    }
}