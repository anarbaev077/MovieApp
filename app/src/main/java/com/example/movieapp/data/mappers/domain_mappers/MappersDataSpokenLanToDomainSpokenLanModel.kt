package com.example.movieapp.data.mappers.domain_mappers

import com.example.movieapp.data.models.kinofy_info_data.spoken_language_data.SpokenLanguage
import com.example.movieapp.domain.model.info_domain_model.spoken_language_domain.SpokenLanguagePresentationModel


// Spoken Language
fun SpokenLanguage.toDomain() = SpokenLanguagePresentationModel(
    englishName = englishName,
    iso6391 = iso6391,
    name = name,
)