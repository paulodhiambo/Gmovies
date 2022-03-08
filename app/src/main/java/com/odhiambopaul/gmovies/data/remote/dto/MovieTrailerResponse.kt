package com.odhiambopaul.gmovies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class MovieTrailerResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("results")
    val movieTrailerDtos: List<MovieTrailerDto>?
)