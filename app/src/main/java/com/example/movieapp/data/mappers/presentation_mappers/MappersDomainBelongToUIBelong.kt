package com.example.movieapp.data.mappers.presentation_mappers

import com.example.movieapp.data.models.kinofy_info_data.belongs_to_collection_data.BelongsToCollection
import com.example.movieapp.domain.model.info_domain_model.belongs_to_collection_domain.BelongsToCollectionPresentationModel

// Belongs To Collection
fun BelongsToCollection.toUi() = BelongsToCollectionPresentationModel(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath,
)