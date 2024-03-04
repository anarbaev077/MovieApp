package com.example.movieapp.presentation.navigation

import android.annotation.SuppressLint
import com.example.movieapp.R

@SuppressLint("SupportAnnotationUsage")
sealed class ScreensForNavigation(val route: String) {

    data object SplashScreen : ScreensForNavigation(R.string.splash_screen.toString())

    data object HomeScreen : ScreensForNavigation(R.string.main_screen.toString())

    data object SearchScreen : ScreensForNavigation(R.string.search_screen.toString())

    data object Favorite : ScreensForNavigation(R.string.favorite_screen.toString())

    data object DetailsScreen : ScreensForNavigation(R.string.details_screen.toString())

    data object Settings : ScreensForNavigation(R.string.settings_screen.toString())
}