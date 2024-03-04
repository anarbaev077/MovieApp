package com.example.movieapp.presentation.components.bottom_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R
import com.example.movieapp.presentation.components.different_screens.KinofyList
import com.example.movieapp.presentation.components.tab_rows.for_main_screen.TabRowForMainScreen
import com.example.movieapp.presentation.models.base_models.KinofyPresentationModel
import com.example.movieapp.presentation.models.base_models.KinofyPresentationResponseModel
import com.example.movieapp.presentation.screens.screen_main.MainScreenUiState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AnimatedBottomBar(
//    navController: NavController,
    modifier: Modifier = Modifier,
    uiState: MainScreenUiState.Success,
    onNavigateToInfo: (Int) -> Unit,

    ) {
    val systemUiController = rememberSystemUiController()
    val colorBackground = MaterialTheme.colorScheme.background
    val mainTab = IconsForBottomBar(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = painterResource(id = R.drawable.unselected_icon_home)
    )
    val searchTab = IconsForBottomBar(
        title = "Search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = painterResource(id = R.drawable.unselected_icon_search)
    )
    val favoriteTab = IconsForBottomBar(
        title = "Favorite",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = painterResource(id = R.drawable.unselected_icon_favorite)
    )
    val settingsTab = IconsForBottomBar(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = painterResource(id = R.drawable.unselected_icon_settings)
    )
    val bottomBarItems = listOf(mainTab, searchTab, favoriteTab, settingsTab)
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = colorBackground
            ) {
                bottomBarItems.forEachIndexed { _, bottomBarItem ->
                    BottomNavigationItem(
                        selected = true,
                        onClick = { },
                        icon = {
                            Icon(
                                painter = bottomBarItem.unselectedIcon, contentDescription = null
                            )
                        },
                        label = {
                            Text(text = bottomBarItem.title, fontSize = 12.sp)
                        },
                    )
                }
            }
        },
    ) { innerPadding ->
        Column {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier.padding(top = 8.dp, start = 10.dp)
                ) {
                    KinofyList(kinoList = uiState.kinofyPopular)
                    TabRowForMainScreen(uiState = uiState, onNavigateToInfo = onNavigateToInfo99)
                }
            }
        }
    }
    SideEffect {
        systemUiController.setStatusBarColor(colorBackground)
        systemUiController.setNavigationBarColor(colorBackground)
    }
}