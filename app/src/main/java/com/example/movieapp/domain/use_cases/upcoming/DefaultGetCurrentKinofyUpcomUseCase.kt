package com.example.movieapp.domain.use_cases.upcoming

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyRepository
import javax.inject.Inject

class DefaultGetCurrentKinofyUpcomUseCase @Inject constructor(
    private val repository: GetKinofyRepository
) : GetCurrentKinofyUpcomUseCase {

    override suspend fun invoke(): ResultStatus<List<KinofyDomainModel>> {
        return repository.getUpcomingMovie()
    }
}