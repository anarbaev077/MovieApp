package com.example.movieapp.domain.use_cases.upcoming_use_cases

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyesRepository
import javax.inject.Inject

class DefaultGetCurrentKinofyUpcomUseCase @Inject constructor(
    private val repository: GetKinofyesRepository
) : GetCurrentKinofyUpcomUseCase {

    override suspend fun invoke(): ResultStatus<List<KinofyDomainModel>> {
        return repository.getUpcomingMovie()
    }
}