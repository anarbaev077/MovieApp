package com.example.movieapp.domain.models.search_model

import java.io.Serializable

data class SearchKinofyResponseDomainModel(
    val result: List<SearchKinofyDomainModel>
) : Serializable {
    companion object {
        val unknown = SearchKinofyResponseDomainModel(
            result = emptyList()
        )
    }
}