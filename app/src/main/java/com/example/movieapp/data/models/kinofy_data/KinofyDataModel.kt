package com.example.movieapp.data.models.kinofy_data

import com.example.movieapp.data.links.Links
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class KinofyDataModel(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
) : Serializable {
    companion object {
        val unknown = KinofyDataModel (
            backdropPath = Links.EMPTY_STRING,
            genreIds = listOf(0),
            movieId = 0,
            originalLanguage = Links.EMPTY_STRING,
            originalTitle = Links.EMPTY_STRING,
            overview = Links.EMPTY_STRING,
            popularity = 0.0,
            posterPath = Links.EMPTY_STRING,
            releaseDate = Links.EMPTY_STRING,
            title = Links.EMPTY_STRING,
            voteAverage = 0.0,
            voteCount = 0,
        )
    }
}