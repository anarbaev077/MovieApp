package com.example.movieapp.presentation.components.tab_rows.for_main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.presentation.components.item.KinofyItem
import com.example.movieapp.presentation.screens.screen_main.MainScreenUiState
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowForMainScreen(
    uiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier,
    onNavigateToInfo: (Int) -> Unit
) {
    val listof = listOf(
        uiState.kinofyPopular,
        uiState.kinofyTop,
        uiState.kinofyUpcoming,
        uiState.kinofyNowPlaying,
    )
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState { listof.size }
    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
        Box(
            modifier = modifier
                .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                .height(3.dp)
                .background(
                    color = Color.Blue
                ),
        )
    }
    Column(
        modifier = Modifier, verticalArrangement = Arrangement.Center
    ) {
        ScrollableTabRow(
            modifier = Modifier,
            selectedTabIndex = pagerState.currentPage,
            indicator = defaultIndicator,
            containerColor = Color.Transparent
        ) {
            listof.forEachIndexed { index, _ ->
                val list = getListOfPageByPosition(index)
                Tab(
                    text = {
                        Text(
                            text = list,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
        ) { movie ->
            val scope = listof[movie]
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(items = scope, key = { it.kinofyesIds }) {
                    KinofyItem(
                        image = it.poster,
                        kinofyId = it.kinofyesIds,
                        onNavigateToInfo = onNavigateToInfo
                    )
                }
            }
        }
    }
}

@Composable
fun getListOfPageByPosition(position: Int): String = when (position) {
    0 -> "Popular"
    1 -> "Top Rated"
    2 -> "Now Playing"
    else -> "Upcoming"
}