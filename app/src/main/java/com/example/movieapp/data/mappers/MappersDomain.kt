package com.example.movieapp.data.mappers

import com.example.movieapp.data.models.kinofy_data.KinofyDataModel
import com.example.movieapp.data.models.kinofy_data.KinofyResponseDataModel
import com.example.movieapp.data.models.kinofy_info_data.base_details.KinofyInfo
import com.example.movieapp.data.models.kinofy_info_data.belongs_to_collection_data.BelongsToCollection
import com.example.movieapp.data.models.kinofy_info_data.details_genres_data.Genre
import com.example.movieapp.data.models.kinofy_info_data.production_company_data.ProductionCompany
import com.example.movieapp.data.models.kinofy_info_data.production_country_data.ProductionCountry
import com.example.movieapp.data.models.kinofy_info_data.spoken_language_data.SpokenLanguage
import com.example.movieapp.data.models.kinofy_search.base_search_models.KinofySearchDataModel
import com.example.movieapp.data.models.kinofy_search.base_search_models.KinofySearchResponseDataModel
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.model.base_domain_model.KinofyResponseDomainModel
import com.example.movieapp.domain.model.info_domain_model.base_models_info.InfoKinofyDomainModel
import com.example.movieapp.domain.model.info_domain_model.belongs_to_collection_domain.BelongsToCollectionPresentationModel
import com.example.movieapp.domain.model.info_domain_model.details_genres_model_domain.GenresPresentationModel
import com.example.movieapp.domain.model.info_domain_model.production_company_domain.ProductionCompanyPresentationModel
import com.example.movieapp.domain.model.info_domain_model.production_country_domain.ProductionCountryPresentationModel
import com.example.movieapp.domain.model.info_domain_model.spoken_language_domain.SpokenLanguagePresentationModel
import com.example.movieapp.domain.models.search_model.SearchKinofyDomainModel
import com.example.movieapp.domain.models.search_model.SearchKinofyResponseDomainModel

// KINOFYES
fun KinofyDataModel.toDomain() = KinofyDomainModel(
    backdropPath = backdropPath,
    genreIds = genreIds,
    movieId = movieId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

fun KinofyResponseDataModel.toDomain() = KinofyResponseDomainModel(
    result = result.map { it.toDomain() }
)

// DETAILS
fun KinofyInfo.toDomain() = InfoKinofyDomainModel(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = listOf(belongsToCollection),
    budget = budget,
    genres = genres,
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies,
    productionCountries = productionCountries,
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages,
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

// Belongs To Collection
fun BelongsToCollection.toDomain() = BelongsToCollectionPresentationModel(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath,
)


// Details Genres
fun Genre.toDomain() = GenresPresentationModel(
    id = id,
    name = name,
)


// Production Company

fun ProductionCompany.toDomain() = ProductionCompanyPresentationModel(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry,
)


//Production Country

fun ProductionCountry.toDomain() = ProductionCountryPresentationModel(
    iso31661 = iso31661,
    name = name
)
// Spoken Language
fun SpokenLanguage.toDomain() = SpokenLanguagePresentationModel(
    englishName = englishName,
    iso6391 = iso6391,
    name = name,
)

// SEARCH
fun KinofySearchDataModel.toDomain() = SearchKinofyDomainModel(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTaitl = originalTaitl,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    taitl = taitl,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

fun KinofySearchResponseDataModel.toDomain() = SearchKinofyResponseDomainModel(
    result = result.map { it.toDomain() }
)