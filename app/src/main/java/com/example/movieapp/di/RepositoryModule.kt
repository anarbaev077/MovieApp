package com.example.movieapp.di

import com.example.movieapp.data.remote.KinofyService
import com.example.movieapp.data.repository.DefaultGetCurrentKinofyRepository
import com.example.movieapp.domain.repository.GetKinofyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providesGetCurrentMovieRepository(
        service: KinofyService
    ): GetKinofyRepository = DefaultGetCurrentKinofyRepository(
        service = service
    )
}