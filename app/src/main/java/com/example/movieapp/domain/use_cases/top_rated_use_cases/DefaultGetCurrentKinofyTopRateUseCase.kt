package com.example.movieapp.domain.use_cases.top_rated_use_cases

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyesRepository
import javax.inject.Inject

class DefaultGetCurrentKinofyTopRateUseCase @Inject constructor(
    private val repository: GetKinofyesRepository
) : GetCurrentKinofyTopRateUseCase {

    override suspend fun invoke(): ResultStatus<List<KinofyDomainModel>> {
        return repository.getTopRatedMovie()
    }
}