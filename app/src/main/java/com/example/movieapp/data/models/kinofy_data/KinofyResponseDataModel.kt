package com.example.movieapp.data.models.kinofy_data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class KinofyResponseDataModel(
    @SerializedName("results")
    val result: List<KinofyDataModel>
) : Serializable  {
    companion object {
        val unknown =  KinofyResponseDataModel (
            result = emptyList()
        )
    }
}