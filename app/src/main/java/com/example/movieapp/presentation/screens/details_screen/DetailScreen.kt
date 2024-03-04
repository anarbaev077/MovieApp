package com.example.movieapp.presentation.screens.details_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.movieapp.presentation.components.different_screens.ErrorScreen
import com.example.movieapp.presentation.screens.details_screen.details_different_screens.DetailsScreens
import com.example.movieapp.presentation.screens.details_screen.details_different_screens.LoadingDetailsScreen
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DetailScreen(
    viewModel: DetailsScreenViewModel,
    uiState: StateFlow<DetailsScreenUiState>,
    onGetKinofyInfo: () -> Unit
) {

    when (val uiStateFlow = uiState.collectAsState().value) {
        is DetailsScreenUiState.Loading -> {
            LoadingDetailsScreen()
        }
        is DetailsScreenUiState.Success -> {
            DetailsScreens(
                uiState = uiStateFlow,
            )
        }

        is DetailsScreenUiState.Error -> {
            ErrorScreen(
                tryAgainCallback = {
                    viewModel::getKinofyInfo
                }
            )
        }
    }
    LaunchedEffect(key1 = true) {
        onGetKinofyInfo()
    }
}