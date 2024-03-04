package com.example.movieapp.domain.models.search_model

import com.example.movieapp.presentation.theme.EMPTY_STRING
import java.io.Serializable

data class SearchKinofyDomainModel(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTaitl: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val taitl: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) : Serializable {
    companion object {
        val unknown = SearchKinofyDomainModel(
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
