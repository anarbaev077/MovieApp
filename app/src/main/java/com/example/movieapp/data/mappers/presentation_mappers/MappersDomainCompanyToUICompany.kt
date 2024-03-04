package com.example.movieapp.data.mappers.presentation_mappers

import com.example.movieapp.data.models.kinofy_info_data.production_company_data.ProductionCompany
import com.example.movieapp.domain.model.info_domain_model.production_company_domain.ProductionCompanyPresentationModel

// Production Company

fun ProductionCompany.toUi() = ProductionCompanyPresentationModel(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry,
)