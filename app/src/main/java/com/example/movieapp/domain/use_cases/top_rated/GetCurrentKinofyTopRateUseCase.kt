package com.example.movieapp.domain.use_cases.top_rated

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel

interface GetCurrentKinofyTopRateUseCase {
    suspend operator fun invoke(): ResultStatus<List<KinofyDomainModel>>
}