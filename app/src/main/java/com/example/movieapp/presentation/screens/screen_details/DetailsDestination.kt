package com.example.movieapp.presentation.screens.screen_details

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movieapp.presentation.navigation.DestinationForNavigation

object DetailsDestination : DestinationForNavigation {

    override val route: String
        get() = "details_screen"

    const val kinofyId = "movieId"

    val routeWithArgs = "$route/{$kinofyId}"

    val arguments = listOf(navArgument(kinofyId) { type = NavType.IntType })
}