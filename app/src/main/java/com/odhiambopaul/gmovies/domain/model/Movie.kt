package com.odhiambopaul.gmovies.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.odhiambopaul.gmovies.common.MovieTypes

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val movieType: MovieTypes
)
