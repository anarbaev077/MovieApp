package com.example.movieapp.domain.use_cases.now_playing_use_cases

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyesRepository
import javax.inject.Inject

class DefaultGetCurrentKinofyNowPlayUseCase @Inject constructor(
    private val repository: GetKinofyesRepository
) : GetCurrentKinofyNowPlayingUseCase {

    override suspend fun invoke(): ResultStatus<List<KinofyDomainModel>> {
        return repository.getNowPlayingMovie()
    }
}