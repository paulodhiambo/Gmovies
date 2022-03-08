package com.odhiambopaul.gmovies.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.odhiambopaul.gmovies.common.MovieTypes
import com.odhiambopaul.gmovies.domain.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE movieType =:movie_type")
    suspend fun getMovies(movie_type: MovieTypes): List<Movie>

    @Query("SELECT * FROM movies WHERE id= :id")
    suspend fun getMovieById(id: Int): Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: Movie)

}