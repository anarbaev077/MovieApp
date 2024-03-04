package com.example.movieapp.presentation.screens.screen_search

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.movieapp.presentation.models.base_models.KinofyPresentationModel
import kotlinx.collections.immutable.ImmutableList

@Stable
sealed class SearchScreenUiState {
    @Stable
    data class Success(
        val moviePopular: ImmutableList<KinofyPresentationModel>,
        val movieTopRated: ImmutableList<KinofyPresentationModel>,
        val movieUpcoming: ImmutableList<KinofyPresentationModel>,
        val movieNowPlaying: ImmutableList<KinofyPresentationModel>,
    ) : SearchScreenUiState()

    data object Loading : SearchScreenUiState()

    @Immutable
    data class Error(
        val massage: String,
    ) : SearchScreenUiState()
}