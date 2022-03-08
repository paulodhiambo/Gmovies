package com.odhiambopaul.gmovies.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.odhiambopaul.gmovies.domain.model.MovieTrailer

data class MovieTrailerDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("iso_3166_1")
    val iso31661: String?,
    @SerializedName("iso_639_1")
    val iso6391: String?,
    @SerializedName("key")
    val key: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("official")
    val official: Boolean?,
    @SerializedName("published_at")
    val publishedAt: String?,
    @SerializedName("site")
    val site: String?,
    @SerializedName("size")
    val size: Int?,
    @SerializedName("type")
    val type: String?
)

fun MovieTrailerDto.toMovieTrailer() =
    MovieTrailer(id = id, key = key, name = name, site = site, size = size, type = type)