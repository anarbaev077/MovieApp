package com.example.movieapp.data.models.kinofy_search.base_search_models

import java.io.Serializable

data class KinofySearchResponseDataModel(

    val result: List<KinofySearchDataModel>
) : Serializable {
    companion object {
        val unknown = KinofySearchResponseDataModel(
            result = emptyList()
        )
    }
}