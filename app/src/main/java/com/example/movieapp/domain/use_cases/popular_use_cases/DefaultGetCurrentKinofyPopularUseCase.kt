package com.example.movieapp.domain.use_cases.popular_use_cases

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyesRepository
import javax.inject.Inject

class DefaultGetCurrentKinofyPopularUseCase @Inject constructor(
    private val repository: GetKinofyesRepository
) : GetCurrentKinofyPopularUseCase {

    override suspend fun invoke(): ResultStatus<List<KinofyDomainModel>> {
        return repository.getPopularMovie()
    }
}