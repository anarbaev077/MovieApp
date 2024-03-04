package com.example.movieapp.presentation.screens.screen_main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.movieapp.R
import com.example.movieapp.presentation.components.bottom_bar.AnimatedBottomBar
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
    val backgroundColor = MaterialTheme.colors.background

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            modifier = modifier
                .background(backgroundColor),
            onClick = {}
        ) {
            Text(text = "")
            Image(painterResource(id = R.drawable.unselected_icon_search), contentDescription = null)
        }
    }


    when (uiState) {
        is MainScreenUiState.Loading -> LoadingScreen()
        is MainScreenUiState.Success -> {
            AnimatedBottomBar(
                uiState = uiState,
                onNavigateToInfo = onNavigateToInfo
            )
        }

        is MainScreenUiState.Error -> ErrorScreen {}
    }
}
