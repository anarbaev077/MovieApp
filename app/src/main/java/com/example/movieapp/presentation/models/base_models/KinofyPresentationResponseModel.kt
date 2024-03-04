package com.example.movieapp.presentation.models.base_models

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