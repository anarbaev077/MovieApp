package com.example.movieapp.data.mappers.domain_mappers

import com.example.movieapp.data.models.kinofy_info_data.details_genres_data.Genre
import com.example.movieapp.domain.model.info_domain_model.details_genres_model_domain.GenresPresentationModel


// Details Genres
fun Genre.toDomain() = GenresPresentationModel(
    id = id,
    name = name,
)