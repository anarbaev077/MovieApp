package com.example.movieapp.data.models.kinofy_search.search_model

import com.example.movieapp.data.models.kinofy_search.base_search_models.KinofySearchDataModel
import com.google.gson.annotations.SerializedName

data class KinofySearchModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<KinofySearchDataModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)