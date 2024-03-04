package com.example.movieapp.domain.model.base_domain_model

import java.io.Serializable

data class KinofyResponseDomainModel(
    val result: List<KinofyDomainModel>
) : Serializable  {
    companion object {
        val unknown =  KinofyResponseDomainModel (
            result = emptyList()
        )
    }
}