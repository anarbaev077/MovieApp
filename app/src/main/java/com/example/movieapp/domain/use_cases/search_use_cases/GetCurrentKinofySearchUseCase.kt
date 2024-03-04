package com.example.movieapp.domain.use_case.search
import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.search_model.SearchKinofyDomainModel

interface GetCurrentKinofySearchUseCase {

    suspend operator fun invoke(query: String): ResultStatus<List<SearchKinofyDomainModel>>
}