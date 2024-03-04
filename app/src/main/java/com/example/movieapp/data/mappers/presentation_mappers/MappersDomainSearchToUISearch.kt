package com.example.movieapp.data.mappers.presentation_mappers

import com.example.movieapp.domain.models.search_model.SearchKinofyDomainModel
import com.example.movieapp.domain.models.search_model.SearchKinofyResponseDomainModel
import com.example.movieapp.presentation.models.search_models.SearchKinofyPresentationModel
import com.example.movieapp.presentation.models.search_models.SearchKinofyPresentationResponseModel

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