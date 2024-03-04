package com.example.movieapp.presentation.screens.screen_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.movieapp.presentation.components.different_screens.ErrorScreen
import com.example.movieapp.presentation.components.different_screens.LoadingScreen
import com.example.movieapp.presentation.components.tab_rows.for_details_screen.DetailsUi
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DetailScreen(
    viewModel: DetailsScreenViewModel,
    uiState: StateFlow<DetailsScreenUiState>,
    onGetKinofyInfo: () -> Unit
) {
    when (val uiStateFlow = uiState.collectAsState().value) {
        is DetailsScreenUiState.Loading -> {
            LoadingScreen()
        }
        is DetailsScreenUiState.Success -> {
            DetailsUi(
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