package com.example.movieapp.data.mappers.presentation_mappers

import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.presentation.models.base_models.KinofyPresentationModel

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
