package com.example.movieapp.presentation.screens.details_screen

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.movieapp.presentation.models.info.base_models_info_presentation.InfoKinofyPresentationModel

@Immutable
sealed class DetailsScreenUiState {

    @Stable
    data class Success(
        val overview: InfoKinofyPresentationModel,
        val detailsKinofy: InfoKinofyPresentationModel
    ) : DetailsScreenUiState()

    data object Loading : DetailsScreenUiState()

    @Immutable
    data class Error(
        val message: String,
        val isErrorWithConnection: Boolean
    ) : DetailsScreenUiState()
}