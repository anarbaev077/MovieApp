package com.example.movieapp.presentation.screens.screen_main

import android.annotation.SuppressLint
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.movieapp.presentation.components.bottom_bar.BottomBarScreen
import com.example.movieapp.presentation.components.different_screens.ErrorScreen
import com.example.movieapp.presentation.components.different_screens.LoadingScreen

@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen(
    mainScreenViewModel: MainScreenViewModel,
    uiState: MainScreenUiState,
    modifier: Modifier = Modifier,
    onNavigateToInfo: (Int) -> Unit,
    onNavigateToSearchScreen: () -> Unit,
) {

    TextButton(onClick = {}) {

    }
    var search by remember {
        mutableStateOf("")
    }
    val backgroundColor = MaterialTheme.colors.background
    val buttonColors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = backgroundColor
    )
        when (uiState) {
            is MainScreenUiState.Loading -> LoadingScreen()
            is MainScreenUiState.Success -> {
                BottomBarScreen(uiState = uiState, onNavigateToInfo = onNavigateToInfo)
            }

            is MainScreenUiState.Error -> ErrorScreen {}
        }
    }
