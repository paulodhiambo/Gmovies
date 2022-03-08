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

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(id: Int): Flow<Resource<Movie>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovieDetails(id).toMovie(movieType = MovieTypes.POPULAR)
            emit(Resource.Success(movie))
        } catch (e: HttpException) {
            //fall back to local database
            emit(Resource.Success(repository.getLocalMovieById(id)))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Movie with the id $id not found"))
        }
    }
}