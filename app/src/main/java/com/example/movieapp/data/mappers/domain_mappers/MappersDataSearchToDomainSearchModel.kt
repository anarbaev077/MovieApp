package com.example.movieapp.data.mappers.domain_mappers

import com.example.movieapp.data.models.kinofy_search_data.base_search_models.KinofySearchDataModel
import com.example.movieapp.data.models.kinofy_search_data.base_search_models.KinofySearchResponseDataModel
import com.example.movieapp.domain.models.search_model.SearchKinofyDomainModel
import com.example.movieapp.domain.models.search_model.SearchKinofyResponseDomainModel

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

fun KinofySearchResponseDataModel.toDomain() =
    SearchKinofyResponseDomainModel(result = result.map { it.toDomain() })