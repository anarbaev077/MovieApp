package com.example.movieapp.domain.use_cases.popular_use_cases

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel

interface GetCurrentKinofyPopularUseCase {

    suspend operator fun invoke(): ResultStatus<List<KinofyDomainModel>>
}