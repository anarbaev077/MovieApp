package com.example.movieapp.presentation.screens.screen_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.data.mappers.toUi
import com.example.movieapp.domain.use_cases.now_playing.GetCurrentKinofyNowPlayingUseCase
import com.example.movieapp.domain.use_cases.popular.GetCurrentKinofyPopularUseCase
import com.example.movieapp.domain.use_cases.top_rated.GetCurrentKinofyTopRateUseCase
import com.example.movieapp.domain.use_cases.upcoming.GetCurrentKinofyUpcomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentKinofyPopularUseCase: GetCurrentKinofyPopularUseCase,
    private val getCurrentKinofyNowPlayingUseCase: GetCurrentKinofyNowPlayingUseCase,
    private val getCurrentMovieUpcomingUseCase: GetCurrentKinofyUpcomUseCase,
    private val getCurrentMovieTopRatedUseCase: GetCurrentKinofyTopRateUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        kinofyes()
    }

    private fun kinofyes() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            val popularResponse = getCurrentKinofyPopularUseCase()
            val upcomingUseCase = getCurrentMovieUpcomingUseCase()
            val nowPLayingResponse = getCurrentKinofyNowPlayingUseCase()
            val topRatedResponse = getCurrentMovieTopRatedUseCase()

            if (
                popularResponse.status == ResponseStatus.SUCCESS &&
                topRatedResponse.status == ResponseStatus.SUCCESS &&
                upcomingUseCase.status == ResponseStatus.SUCCESS &&
                nowPLayingResponse.status == ResponseStatus.SUCCESS
            ) {
                popularResponse.data?.let { popularMovies ->
                    upcomingUseCase.data?.let { upcomingMovies ->
                        topRatedResponse.data?.let { topRatedMovies ->
                            nowPLayingResponse.data?.let { nowPlayingMovies ->
                                _uiState.update {
                                    MainScreenUiState.Success(
                                        kinofyPopular = popularMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        kinofyUpcoming = upcomingMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        kinofyTop = topRatedMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        kinofyNowPlaying = nowPlayingMovies.map { it.toUi() }
                                            .toImmutableList(),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}