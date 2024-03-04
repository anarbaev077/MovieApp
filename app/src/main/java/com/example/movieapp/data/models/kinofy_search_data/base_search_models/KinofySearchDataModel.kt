package com.example.movieapp.data.models.kinofy_search_data.base_search_models

import com.example.movieapp.presentation.theme.EMPTY_STRING
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class KinofySearchDataModel(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTaitl: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val taitl: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
): Serializable {
    companion object {
        val unknown = KinofySearchDataModel(
            adult = false,
            backdropPath = EMPTY_STRING,
            genreIds = listOf(0),
            id = 0,
            originalLanguage = EMPTY_STRING,
            originalTaitl = EMPTY_STRING,
            overview = EMPTY_STRING,
            popularity = 0.0,
            posterPath = EMPTY_STRING,
            releaseDate = EMPTY_STRING,
            taitl = EMPTY_STRING,
            video = false,
            voteAverage = 0.0,
            voteCount = 0
        )
    }
}