package com.example.movieapp.presentation.screens.screen_splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.R
import com.example.movieapp.presentation.components.lottie_animations.SplashScreenLottie
import com.example.movieapp.presentation.theme.SPLASH_SCREEN
import com.example.movieapp.presentation.theme.dp70
import com.example.movieapp.presentation.theme.sp38
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    callbackToMainScreen: () -> Unit,
) {

    val background = MaterialTheme.colorScheme.background
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(background)
        systemUiController.setNavigationBarColor(background)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier.padding(bottom = dp70),
            text = stringResource(id = R.string.kinofy),
            fontSize = sp38
        )
    }


    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            delay(SPLASH_SCREEN)
            callbackToMainScreen()
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
        callbackToMainScreen = {},
    )
}