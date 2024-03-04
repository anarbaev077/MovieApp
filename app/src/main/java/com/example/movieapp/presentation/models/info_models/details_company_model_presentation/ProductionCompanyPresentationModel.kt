package com.example.movieapp.domain.model.info_domain_model.production_company_domain

data class ProductionCompanyPresentationModel(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)
