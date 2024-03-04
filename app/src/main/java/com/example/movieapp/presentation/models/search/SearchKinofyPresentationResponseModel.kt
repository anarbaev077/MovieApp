package com.example.movieapp.presentation.models.search

import com.google.gson.annotations.SerializedName
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