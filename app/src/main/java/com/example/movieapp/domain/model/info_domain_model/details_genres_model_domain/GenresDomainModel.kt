package com.example.movieapp.domain.model.info_domain_model.details_genres_model_domain

import com.example.movieapp.presentation.theme.EMPTY_STRING
import java.io.Serializable

data class GenresDomainModel(
    val id: Int,
    val name: String
) : Serializable {
    companion object {
        val unknown = GenresPresentationModel(
            id = 0,
            name = EMPTY_STRING
        )
    }
}

