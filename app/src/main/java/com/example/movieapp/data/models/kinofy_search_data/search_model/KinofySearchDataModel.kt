package com.example.movieapp.data.models.kinofy_search_data.search_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class KinofySearchDataModel(
    @SerializedName("results")
    val results: List<KinofySearchModel>
) : Serializable {
    companion object {
        val unknown = KinofySearchDataModel(
            results = emptyList()
        )
    }
}
