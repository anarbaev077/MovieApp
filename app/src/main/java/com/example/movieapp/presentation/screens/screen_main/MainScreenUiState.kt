package com.example.movieapp.presentation.screens.screen_main

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.movieapp.presentation.models.base_models.KinofyPresentationModel
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class MainScreenUiState {

    @Stable
    data class Success(
        val kinofyPopular: ImmutableList<KinofyPresentationModel>,
        val kinofyTop: ImmutableList<KinofyPresentationModel>,
        val kinofyUpcoming: ImmutableList<KinofyPresentationModel>,
        val kinofyNowPlaying: ImmutableList<KinofyPresentationModel>,
    ) : MainScreenUiState()

    data object Loading : MainScreenUiState()

    @Immutable
    data class Error(
        val massage: String,
    ) : MainScreenUiState()
}