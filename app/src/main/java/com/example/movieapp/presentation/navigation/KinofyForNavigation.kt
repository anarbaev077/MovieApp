package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.screens.screen_details.DetailScreen
import com.example.movieapp.presentation.screens.screen_details.DetailsDestination
import com.example.movieapp.presentation.screens.screen_details.DetailsScreenViewModel
import com.example.movieapp.presentation.screens.screen_main.MainScreen
import com.example.movieapp.presentation.screens.screen_main.MainScreenViewModel
import com.example.movieapp.presentation.screens.screen_splash.SplashScreen

@Composable
fun KinofyNavigation() {

    val navController = rememberNavController()
    val splashScreenRoute = ScreensForNavigation.SplashScreen.route
    val homeScreenRoute = ScreensForNavigation.HomeScreen.route
    val searchScreenRoute = ScreensForNavigation.SearchScreen.route
    val mainScreenViewModel: MainScreenViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = splashScreenRoute,
    ) {
        composable(splashScreenRoute) {
            SplashScreen(
                callbackToMainScreen = {
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
                    navController.navigate("${DetailsDestination.route}/$movieId")
                }
            )
        }
        composable(
            route = DetailsDestination.routeWithArgs,
            arguments = DetailsDestination.arguments,
        ) { navBackStackEntry ->
            val movieId =
                navBackStackEntry.arguments?.getInt(DetailsDestination.kinofyId) ?: 0
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
