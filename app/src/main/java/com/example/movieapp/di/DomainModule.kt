package com.example.movieapp.di

import com.example.movieapp.domain.repository.GetKinofyesRepository
import com.example.movieapp.domain.use_case.info.DefaultGetCurrentKinofyInfoUseCase
import com.example.movieapp.domain.use_case.info.GetCurrentKinofyInfoUseCase
import com.example.movieapp.domain.use_case.search.DeafultKinofySearchUseCase
import com.example.movieapp.domain.use_case.search.GetCurrentKinofySearchUseCase
import com.example.movieapp.domain.use_cases.now_playing_use_cases.DefaultGetCurrentKinofyNowPlayUseCase
import com.example.movieapp.domain.use_cases.now_playing_use_cases.GetCurrentKinofyNowPlayingUseCase
import com.example.movieapp.domain.use_cases.popular_use_cases.DefaultGetCurrentKinofyPopularUseCase
import com.example.movieapp.domain.use_cases.popular_use_cases.GetCurrentKinofyPopularUseCase
import com.example.movieapp.domain.use_cases.top_rated_use_cases.DefaultGetCurrentKinofyTopRateUseCase
import com.example.movieapp.domain.use_cases.top_rated_use_cases.GetCurrentKinofyTopRateUseCase
import com.example.movieapp.domain.use_cases.upcoming_use_cases.DefaultGetCurrentKinofyUpcomUseCase
import com.example.movieapp.domain.use_cases.upcoming_use_cases.GetCurrentKinofyUpcomUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesGetCurrentMoviePopularUseCase(
        repository: GetKinofyesRepository
    ): GetCurrentKinofyPopularUseCase = DefaultGetCurrentKinofyPopularUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieNowPlayingUseCase(
        repository: GetKinofyesRepository
    ): GetCurrentKinofyNowPlayingUseCase = DefaultGetCurrentKinofyNowPlayUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieUpcomingUseCase(
        repository: GetKinofyesRepository
    ): GetCurrentKinofyUpcomUseCase = DefaultGetCurrentKinofyUpcomUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieTopRatedUseCase(
        repository: GetKinofyesRepository
    ): GetCurrentKinofyTopRateUseCase = DefaultGetCurrentKinofyTopRateUseCase(
        repository = repository
    )

    @Provides
    fun providesGetKinofyInfoUseCase(
        repository: GetKinofyesRepository
    ): GetCurrentKinofyInfoUseCase = DefaultGetCurrentKinofyInfoUseCase(
        repository = repository
    )

    @Provides
    fun providesGetKinofySearchUseCase(
        repository: GetKinofyesRepository
    ): GetCurrentKinofySearchUseCase = DeafultKinofySearchUseCase(
        repository = repository
    )
}