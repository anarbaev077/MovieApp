package com.example.movieapp.presentation.components.tab_rows.for_details_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.movieapp.presentation.screens.screen_details.DetailsScreenUiState
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowDetailScreen(
    modifier: Modifier = Modifier,
    uiState: DetailsScreenUiState.Success
) {
    val listOfParts = listOf(
        "About Movie",
        "Reviews",
        "Cast"
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { listOfParts.size })

    val coroutineScope = rememberCoroutineScope()
    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
        Box(
            modifier = modifier
                .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                .height(3.dp)
                .background(
                    color = Color.Gray
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
            listOfParts.forEachIndexed { index, _ ->
                Tab(
                    text = {
                        Text(
                            text = listOfParts[index],
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
        ) {
            Text(
                modifier = modifier
                    .padding(horizontal = 18.dp)
                    .padding(top = 10.dp),
                text = uiState.detailsKinofy.overview,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}