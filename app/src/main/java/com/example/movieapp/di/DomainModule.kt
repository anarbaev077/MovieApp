package com.example.movieapp.di

import com.example.movieapp.domain.repository.GetKinofyRepository
import com.example.movieapp.domain.use_case.info.DefaultGetCurrentKinofyInfoUseCase
import com.example.movieapp.domain.use_case.info.GetCurrentKinofyInfoUseCase
import com.example.movieapp.domain.use_case.search.DeafultKinofySearchUseCase
import com.example.movieapp.domain.use_case.search.GetCurrentKinofySearchUseCase
import com.example.movieapp.domain.use_cases.now_playing.DefaultGetCurrentKinofyNowPlayUseCase
import com.example.movieapp.domain.use_cases.now_playing.GetCurrentKinofyNowPlayingUseCase
import com.example.movieapp.domain.use_cases.popular.DefaultGetCurrentKinofyPopularUseCase
import com.example.movieapp.domain.use_cases.popular.GetCurrentKinofyPopularUseCase
import com.example.movieapp.domain.use_cases.top_rated.DefaultGetCurrentKinofyTopRateUseCase
import com.example.movieapp.domain.use_cases.top_rated.GetCurrentKinofyTopRateUseCase
import com.example.movieapp.domain.use_cases.upcoming.DefaultGetCurrentKinofyUpcomUseCase
import com.example.movieapp.domain.use_cases.upcoming.GetCurrentKinofyUpcomUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesGetCurrentMoviePopularUseCase(
        repository: GetKinofyRepository
    ): GetCurrentKinofyPopularUseCase = DefaultGetCurrentKinofyPopularUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieNowPlayingUseCase(
        repository: GetKinofyRepository
    ): GetCurrentKinofyNowPlayingUseCase = DefaultGetCurrentKinofyNowPlayUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieUpcomingUseCase(
        repository: GetKinofyRepository
    ): GetCurrentKinofyUpcomUseCase = DefaultGetCurrentKinofyUpcomUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieTopRatedUseCase(
        repository: GetKinofyRepository
    ): GetCurrentKinofyTopRateUseCase = DefaultGetCurrentKinofyTopRateUseCase(
        repository = repository
    )

    @Provides
    fun providesGetKinofyInfoUseCase(
        repository: GetKinofyRepository
    ): GetCurrentKinofyInfoUseCase = DefaultGetCurrentKinofyInfoUseCase(
        repository = repository
    )

    @Provides
    fun providesGetKinofySearchUseCase(
        repository: GetKinofyRepository
    ): GetCurrentKinofySearchUseCase = DeafultKinofySearchUseCase(
        repository = repository
    )
}