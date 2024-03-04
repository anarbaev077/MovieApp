package com.example.movieapp.data.mappers.presentation_mappers

import com.example.movieapp.domain.model.info_domain_model.base_models_info_domain.InfoKinofyDomainModel
import com.example.movieapp.presentation.models.info_models.details_base_models_presentation.InfoKinofyPresentationModel


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