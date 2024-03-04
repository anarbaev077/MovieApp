package com.example.movieapp.domain.use_cases.upcoming_use_cases

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel

interface GetCurrentKinofyUpcomUseCase {

    suspend operator fun invoke(): ResultStatus<List<KinofyDomainModel>>
}