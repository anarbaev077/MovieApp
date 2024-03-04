package com.example.movieapp.presentation.models.models

import androidx.compose.runtime.Stable
import java.io.Serializable

@Stable
data class KinofyPresentationModel(
    val backdropPath: String,
    val genreIds: List<Int>,
    val kinofyesIds: Int,
    val originalLanguage: String,
    val originalTaitl: String,
    val overview: String,
    val popularity: Double,
    val poster: String,
    val releaseDate: String,
    val taitl: String,
    val voteAverage: Double,
    val voteCount: Int,
) : Serializable {
    companion object {
        val unknown = KinofyPresentationModel(
            backdropPath = "",
            genreIds = listOf(0),
            kinofyesIds = 0,
            originalLanguage = "",
            originalTaitl = "",
            overview = "",
            popularity = 0.0,
            poster = "",
            releaseDate = "",
            taitl = "",
            voteAverage = 0.0,
            voteCount = 0,
        )
    }
}