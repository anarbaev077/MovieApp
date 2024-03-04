package com.example.movieapp.data.mappers.domain_mappers

import com.example.movieapp.data.models.kinofy_info_data.base_details.KinofyInfo
import com.example.movieapp.domain.model.info_domain_model.base_models_info_domain.InfoKinofyDomainModel

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