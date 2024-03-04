package com.example.movieapp.domain.model.info_domain_model.base_models_info_domain

import com.example.movieapp.data.models.kinofy_info_data.belongs_to_collection_data.BelongsToCollection
import com.example.movieapp.data.models.kinofy_info_data.details_genres_data.Genre
import com.example.movieapp.data.models.kinofy_info_data.production_company_data.ProductionCompany
import com.example.movieapp.data.models.kinofy_info_data.production_country_data.ProductionCountry
import com.example.movieapp.data.models.kinofy_info_data.spoken_language_data.SpokenLanguage
import com.example.movieapp.presentation.theme.EMPTY_STRING
import java.io.Serializable

data class InfoKinofyDomainModel(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: List<BelongsToCollection>,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
) : Serializable {
    companion object {
        val unknown = InfoKinofyDomainModel(
            adult = false,
            backdropPath = EMPTY_STRING,
            belongsToCollection = listOf(),
            budget = 0,
            genres = listOf(),
            homepage = EMPTY_STRING,
            id = 0,
            imdbId = EMPTY_STRING,
            originalLanguage = EMPTY_STRING,
            originalTitle = EMPTY_STRING,
            overview = EMPTY_STRING,
            popularity = 0.0,
            posterPath = EMPTY_STRING,
            productionCompanies = listOf(),
            productionCountries = listOf(),
            releaseDate = EMPTY_STRING,
            revenue = 0,
            runtime = 0,
            spokenLanguages = listOf(),
            status = EMPTY_STRING,
            tagline = EMPTY_STRING,
            title = EMPTY_STRING,
            video = false,
            voteAverage = 0.0,
            voteCount = 0
        )
    }
}