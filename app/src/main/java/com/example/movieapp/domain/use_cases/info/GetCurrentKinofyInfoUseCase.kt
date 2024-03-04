package com.example.movieapp.domain.use_case.info

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.info_domain_model.base_models_info.InfoKinofyDomainModel

interface GetCurrentKinofyInfoUseCase {
    suspend operator fun invoke(movieId: Int): ResultStatus<InfoKinofyDomainModel>
}