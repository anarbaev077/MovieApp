package com.example.movieapp.presentation.models.search_models

import java.io.Serializable

data class SearchKinofyPresentationResponseModel(
    val result: List<SearchKinofyPresentationModel>
) : Serializable {
    companion object {
        val unknown = SearchKinofyPresentationResponseModel(
            result = emptyList()
        )
    }
}