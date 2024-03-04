package com.example.movieapp.domain.repository

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.model.info_domain_model.base_models_info.InfoKinofyDomainModel
import com.example.movieapp.domain.models.search_model.SearchKinofyDomainModel

interface GetKinofyRepository {

    suspend fun getPopularMovie(): ResultStatus<List<KinofyDomainModel>>

    suspend fun getNowPlayingMovie(): ResultStatus<List<KinofyDomainModel>>

    suspend fun getUpcomingMovie(): ResultStatus<List<KinofyDomainModel>>

    suspend fun getTopRatedMovie(): ResultStatus<List<KinofyDomainModel>>

    suspend fun searchKinofyes(query: String): ResultStatus<List<SearchKinofyDomainModel>>

    suspend fun getInfo(movieId: Int): ResultStatus<InfoKinofyDomainModel>
}