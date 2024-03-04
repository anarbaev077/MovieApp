package com.example.movieapp.domain.model.info_domain_model.belongs_to_collection_domain

import com.example.movieapp.presentation.theme.EMPTY_STRING
import java.io.Serializable

data class BelongsToCollectionPresentationModel(
    val backdropPath: String,
    val id: Int,
    val name: String,
    val posterPath: String,
) : Serializable {
    companion object {
        val unknown = BelongsToCollectionPresentationModel(
            backdropPath = EMPTY_STRING,
            id = 0,
            name = EMPTY_STRING,
            posterPath = EMPTY_STRING,
        )
    }
}
