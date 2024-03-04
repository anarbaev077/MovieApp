package com.example.movieapp.data.repository

import com.example.movieapp.data.base.BasicDataSource
import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.data.mappers.domain_mappers.toDomain
import com.example.movieapp.data.remote.KinofyService
import com.example.movieapp.domain.model.base_domain_model.KinofyDomainModel
import com.example.movieapp.domain.model.info_domain_model.base_models_info_domain.InfoKinofyDomainModel
import com.example.movieapp.domain.models.search_model.SearchKinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyesRepository

class DefaultGetCurrentKinofyesRepository(
    private val service: KinofyService
) : GetKinofyesRepository, BasicDataSource() {

    override suspend fun getPopularMovie(): ResultStatus<List<KinofyDomainModel>> {
        val response = invokeResponseRequest { service.getPopularMovie() }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.result?.map { it.toDomain() },
        )
    }

    override suspend fun getNowPlayingMovie(): ResultStatus<List<KinofyDomainModel>> {
        val response = invokeResponseRequest { service.getNowPlayingMovie() }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.result?.map { it.toDomain() },
        )
    }

    override suspend fun getUpcomingMovie(): ResultStatus<List<KinofyDomainModel>> {
        val response = invokeResponseRequest { service.getUpcomingMovie() }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.result?.map { it.toDomain() },
        )
    }

    override suspend fun getTopRatedMovie(): ResultStatus<List<KinofyDomainModel>> {
        val response = invokeResponseRequest { service.getTopRatedMovie() }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.result?.map { it.toDomain() },
        )
    }

    override suspend fun searchKinofyes(query: String): ResultStatus<List<SearchKinofyDomainModel>> {
        val responseSearchDomainModel = invokeResponseRequest {
            service.getKinofySearch(searchQuery = query)
        }
        return ResultStatus(
            status = responseSearchDomainModel.status,
            errorThrowable = responseSearchDomainModel.errorThrowable,
            data = responseSearchDomainModel.data?.results?.map { it.toDomain() },
        )
    }

    override suspend fun getInfo(movieId: Int): ResultStatus<InfoKinofyDomainModel> {
        val responseInfoDomainModel = invokeResponseRequest {
            service.getInfoKinofy(movieId = movieId)
        }
        return ResultStatus(
            status = responseInfoDomainModel.status,
            errorThrowable = responseInfoDomainModel.errorThrowable,
            data = responseInfoDomainModel.data?.toDomain()
        )
    }
}