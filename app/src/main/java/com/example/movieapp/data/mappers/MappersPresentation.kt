package com.example.movieapp.data.mappers

import com.example.movieapp.data.models.kinofy_info_data.belongs_to_collection_data.BelongsToCollection
import com.example.movieapp.data.models.kinofy_info_data.details_genres_data.Genre
import com.example.movieapp.data.models.kinofy_info_data.production_company_data.ProductionCompany
import com.example.movieapp.data.models.kinofy_info_data.production_country_data.ProductionCountry
import com.example.movieapp.data.models.kinofy_info_data.spoken_language_data.SpokenLanguage
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.model.info_domain_model.base_models_info.InfoKinofyDomainModel
import com.example.movieapp.domain.model.info_domain_model.belongs_to_collection_domain.BelongsToCollectionPresentationModel
import com.example.movieapp.domain.model.info_domain_model.details_genres_model_domain.GenresPresentationModel
import com.example.movieapp.domain.model.info_domain_model.production_company_domain.ProductionCompanyPresentationModel
import com.example.movieapp.domain.model.info_domain_model.production_country_domain.ProductionCountryPresentationModel
import com.example.movieapp.domain.model.info_domain_model.spoken_language_domain.SpokenLanguagePresentationModel
import com.example.movieapp.domain.models.search_model.SearchKinofyDomainModel
import com.example.movieapp.domain.models.search_model.SearchKinofyResponseDomainModel
import com.example.movieapp.presentation.models.info.base_models_info_presentation.InfoKinofyPresentationModel
import com.example.movieapp.presentation.models.models.KinofyPresentationModel
import com.example.movieapp.presentation.models.search.SearchKinofyPresentationModel
import com.example.movieapp.presentation.models.search.SearchKinofyPresentationResponseModel

// KINOFYES
fun KinofyDomainModel.toUi() = KinofyPresentationModel(
    backdropPath = backdropPath,
    genreIds = genreIds,
    kinofyesIds = movieId,
    originalLanguage = originalLanguage,
    originalTaitl = originalTitle,
    overview = overview,
    popularity = popularity,
    poster = posterPath,
    releaseDate = releaseDate,
    taitl = title,
    voteAverage = voteAverage,
    voteCount = voteCount,
)


// DETAILS
fun InfoKinofyDomainModel.toUi() = InfoKinofyPresentationModel(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection,
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
fun BelongsToCollection.toUi() = BelongsToCollectionPresentationModel(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath,
)


// Details Genres

fun Genre.toUi() = GenresPresentationModel(
    id = id,
    name = name,
)

// Production Company

fun ProductionCompany.toUi() = ProductionCompanyPresentationModel(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry,
)

//Production Country

fun ProductionCountry.toUi() = ProductionCountryPresentationModel(
    iso31661 = iso31661,
    name = name
)

// Spoken Language
fun SpokenLanguage.toUi() = SpokenLanguagePresentationModel(
    englishName = englishName,
    iso6391 = iso6391,
    name = name,
)

// SEARCH
fun SearchKinofyDomainModel.toUi() = SearchKinofyPresentationModel(
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
    voteCount = voteCount
)

fun SearchKinofyResponseDomainModel.toUi() = SearchKinofyPresentationResponseModel(
    result = result.map { it.toUi() }
)

