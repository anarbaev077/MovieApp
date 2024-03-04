package com.example.movieapp.data.mappers.domain_mappers

import com.example.movieapp.data.models.kinofy_data.KinofyDataModel
import com.example.movieapp.data.models.kinofy_data.KinofyResponseDataModel
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.model.base_domain_model.KinofyResponseDomainModel

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

fun KinofyResponseDataModel.toDomain() =
    KinofyResponseDomainModel(result = result.map { it.toDomain() })
