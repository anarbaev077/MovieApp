package com.example.movieapp.presentation.models.models

import java.io.Serializable

data class KinofyPresentationResponseModel(
    val results: List<KinofyPresentationModel>
) : Serializable {
    companion object {
        val unknown = KinofyPresentationResponseModel(
            results = emptyList()
        )
    }
}