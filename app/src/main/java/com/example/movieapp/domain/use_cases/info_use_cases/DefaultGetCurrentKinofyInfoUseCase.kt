package com.example.movieapp.domain.use_case.info

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.info_domain_model.base_models_info_domain.InfoKinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyesRepository
import javax.inject.Inject

class DefaultGetCurrentKinofyInfoUseCase @Inject constructor(
    private val repository: GetKinofyesRepository
) : GetCurrentKinofyInfoUseCase {
    override suspend fun invoke(movieId: Int): ResultStatus<InfoKinofyDomainModel> {
        return repository.getInfo(movieId = movieId)
    }
}