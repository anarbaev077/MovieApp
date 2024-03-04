package com.example.movieapp.di

import com.example.movieapp.data.remote.KinofyService
import com.example.movieapp.data.repository.DefaultGetCurrentKinofyesRepository
import com.example.movieapp.domain.repository.GetKinofyesRepository
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
    ): GetKinofyesRepository = DefaultGetCurrentKinofyesRepository(
        service = service
    )
}