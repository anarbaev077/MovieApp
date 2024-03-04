package com.example.movieapp.domain.use_case.search

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.search_model.SearchKinofyDomainModel
import com.example.movieapp.domain.repository.GetKinofyRepository
import javax.inject.Inject

class DeafultKinofySearchUseCase @Inject constructor(
    private val repository: GetKinofyRepository
) : GetCurrentKinofySearchUseCase {

    override suspend fun invoke(query: String): ResultStatus<List<SearchKinofyDomainModel>> {
        return repository.searchKinofyes(query = query)
    }
}