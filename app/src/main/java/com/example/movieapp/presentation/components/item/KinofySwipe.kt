package com.example.movieapp.presentation.components.item

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.links.Links
import com.example.movieapp.presentation.models.base_models.KinofyPresentationModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeList(
    movieList: List<KinofyPresentationModel>
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { movieList.size })

    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
    ) {
        HorizontalPager(state = pagerState) { page ->
            val movie = movieList.getOrNull(page)
            if (movie != null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.1f),
                                    Color.Black.copy(alpha = 0.3f),
                                ),
                                startY = 0f,
                                endY = 500f
                            )
                        )
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .height(350.dp)
                            .fillMaxSize(),
                        model = Links.POSTER + movie.poster,
                        placeholder = painterResource(id = R.drawable.loading_icon),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.Bottom)
                                .padding(start = 26.dp, end = 24.dp, bottom = 8.dp),
                            text = movie.taitl,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}