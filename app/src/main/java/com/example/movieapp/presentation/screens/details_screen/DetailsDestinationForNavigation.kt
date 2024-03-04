package com.example.movieapp.presentation.screens.details_screen

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movieapp.presentation.navigation.DestinationForNavigation

object DetailsDestinationForNavigation : DestinationForNavigation {

    override val route: String
        get() = "details_screen"

    const val kinofyId = "movieId"

    val routeWithArgs = "$route/{$kinofyId}"

    val arguments = listOf(navArgument(kinofyId) { type = NavType.IntType })
}