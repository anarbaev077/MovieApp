package com.example.movieapp.data.models.kinofy_info_data.details_genres_data


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)