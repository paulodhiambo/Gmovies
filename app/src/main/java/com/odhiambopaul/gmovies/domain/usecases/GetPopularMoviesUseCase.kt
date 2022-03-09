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

class GetPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            repository.getPopularMovies()
                .moviesDtos.forEach { repository.saveMovieLocally(it.toMovie(MovieTypes.POPULAR)) }
            val movies = repository.getLocalMovies(MovieTypes.POPULAR)
            emit(Resource.Success(movies))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        } catch (e: IOException) {
            //On network error, fallback to the local database
            val movies = repository.getLocalMovies(MovieTypes.POPULAR)
            emit(Resource.Success(movies))
        }
    }
}