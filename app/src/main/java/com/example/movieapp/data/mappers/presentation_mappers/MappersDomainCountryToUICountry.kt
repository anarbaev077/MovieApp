package com.example.movieapp.data.mappers.presentation_mappers

import com.example.movieapp.data.models.kinofy_info_data.production_country_data.ProductionCountry
import com.example.movieapp.domain.model.info_domain_model.production_country_domain.ProductionCountryPresentationModel

//Production Country

fun ProductionCountry.toUi() = ProductionCountryPresentationModel(
    iso31661 = iso31661,
    name = name
)