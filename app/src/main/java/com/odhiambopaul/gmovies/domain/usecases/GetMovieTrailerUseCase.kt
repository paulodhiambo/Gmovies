package com.odhiambopaul.gmovies.domain.usecases

import com.odhiambopaul.gmovies.common.Resource
import com.odhiambopaul.gmovies.data.remote.dto.toMovieTrailer
import com.odhiambopaul.gmovies.domain.model.MovieTrailer
import com.odhiambopaul.gmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieTrailerUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(id: Int): Flow<Resource<MovieTrailer>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getMovieTrailer(id = id).movieTrailerDtos
            if (result!!.isNotEmpty()) {
                val response = result[0].toMovieTrailer()
                emit(Resource.Success(data = response))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "No internet connection"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }
    }
}