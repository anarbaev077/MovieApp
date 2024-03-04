package com.example.movieapp.domain.use_cases.top_rated

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyRepository
import javax.inject.Inject

class DefaultGetCurrentKinofyTopRateUseCase @Inject constructor(
    private val repository: GetKinofyRepository
) : GetCurrentKinofyTopRateUseCase {

    override suspend fun invoke(): ResultStatus<List<KinofyDomainModel>> {
        return repository.getTopRatedMovie()
    }
}