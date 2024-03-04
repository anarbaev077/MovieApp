package com.example.movieapp.domain.use_cases.now_playing

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel

interface GetCurrentKinofyNowPlayingUseCase {

    suspend operator fun invoke(): ResultStatus<List<KinofyDomainModel>>
}