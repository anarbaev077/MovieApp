package com.example.movieapp.presentation.screens.splash_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.presentation.components.lottie.SplashScreenLottie
import com.example.movieapp.presentation.theme.SPLASH_SCREEN_TIME_MILLIS
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    callbackScreen: () -> Unit,
) {

    val background = MaterialTheme.colorScheme.background
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(background)
        systemUiController.setNavigationBarColor(background)
    }

    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            delay(SPLASH_SCREEN_TIME_MILLIS)
            callbackScreen()
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        SplashScreenLottie()
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        callbackScreen = {},
    )
}