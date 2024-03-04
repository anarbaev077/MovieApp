package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.screens.details_screen.DetailScreen
import com.example.movieapp.presentation.screens.details_screen.DetailsDestinationForNavigation
import com.example.movieapp.presentation.screens.details_screen.DetailsScreenViewModel
import com.example.movieapp.presentation.screens.screen_main.MainScreen
import com.example.movieapp.presentation.screens.screen_main.MainScreenViewModel
import com.example.movieapp.presentation.screens.splash_screen.SplashScreen

@Composable
fun MovieNavigation() {

    val navController = rememberNavController()
    val splashScreenRoute = ScreensForNavigation.SplashScreen.route
    val homeScreenRoute = ScreensForNavigation.HomeScreen.route
    val searchScreenRoute = ScreensForNavigation.SearchScreen.route
    val favoriteListScreenRoute = ScreensForNavigation.WatchListScreen.route
    val detailsScreenRoute = ScreensForNavigation.DetailsScreen.route
    val settingsScreenRoute = ScreensForNavigation.DetailsScreen.route
    val mainScreenViewModel: MainScreenViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = splashScreenRoute,
    ) {
        composable(splashScreenRoute) {
            SplashScreen(
                callbackScreen = {
                    navController.navigate(homeScreenRoute)
                },
            )
        }
        composable(homeScreenRoute) {
            val viewModel: MainScreenViewModel = hiltViewModel()
            MainScreen(
                mainScreenViewModel = mainScreenViewModel,
                uiState = viewModel.uiState.collectAsState().value,
                onNavigateToSearchScreen = { navController.navigate(searchScreenRoute) },
                onNavigateToInfo = { movieId ->
                    navController.navigate("${DetailsDestinationForNavigation.route}/$movieId")
                }
            )
        }
        composable(
            route = DetailsDestinationForNavigation.routeWithArgs,
            arguments = DetailsDestinationForNavigation.arguments,
        ) { navBackStackEntry ->
            val movieId =
                navBackStackEntry.arguments?.getInt(DetailsDestinationForNavigation.kinofyId) ?: 0
            val viewModel: DetailsScreenViewModel = hiltViewModel()
            DetailScreen(
                uiState = viewModel.uiState,
                viewModel = viewModel,
                onGetKinofyInfo = {
                    viewModel.getKinofyInfo(movieId = movieId)
                }
            )
        }
    }
}
