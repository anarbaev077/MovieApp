package com.example.movieapp.presentation.screens.details_screen.details_different_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.models.info.base_models_info_presentation.InfoKinofyPresentationModel
import com.example.movieapp.presentation.screens.details_screen.DetailsScreenUiState
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp3
import com.example.movieapp.presentation.theme.sp17

@Composable
fun DetailsScreens(
    uiState: DetailsScreenUiState.Success,
    modifier: Modifier = Modifier,
) {
    val model = uiState.detailsKinofy
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Row(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Icon(
                    painterResource(id = R.drawable.icon_back_for_pop_back_stack),
                    contentDescription = null
                )
                Text(
                    modifier = modifier
                        .padding(start = 120.dp, top = 2.dp)
                        .align(Alignment.CenterVertically),
                    text = "Detail",
                    fontSize = 22.sp,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    modifier = modifier
                        .padding(start = 125.dp)
                        .size(25.dp),
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null
                )
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .height(250.dp)
                        .fillMaxWidth(),
                    model = Constants.POSTER + model.backdropPath,
                    placeholder = painterResource(id = R.drawable.loading_icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                AsyncImage(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .width(120.dp)
                        .height(160.dp)
                        .align(Alignment.TopStart)
                        .graphicsLayer {
                            translationY = 500f
                        },
                    model = Constants.POSTER + model.posterPath,
                    placeholder = painterResource(id = R.drawable.loading_icon),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
                if (model.title.length > 14) {
                    val firstPart = model.title.take(14)
                    val secondPart = model.title.drop(14)
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(firstPart)
                                append("\n")
                                append(secondPart)
                            }
                        },
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.onBackground,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .graphicsLayer {
                                translationX = 110f
                                translationY = 190f
                            }
                            .align(Alignment.BottomCenter)
                    )
                } else {
                    Text(
                        modifier = modifier
                            .graphicsLayer {
                                translationX = 110f
                                translationY = 190f
                            }
                            .align(Alignment.BottomCenter),
                        text = "Spiderman No Way \n Home",
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
            Row(
                modifier = modifier
                    .padding(top = 100.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = modifier
                        .padding(start = 50.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                )
                Text(
                    modifier = modifier
                        .padding(start = 3.dp)
                        .align(Alignment.CenterVertically),
                    text = "2021   |",
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Medium
                )
                Image(
                    modifier = modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                )
                Text(
                    modifier = modifier
                        .padding(start = 3.dp)
                        .align(Alignment.CenterVertically),
                    text = "148 Minutes  |",
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Medium
                )
                Image(
                    modifier = modifier
                        .padding(start = dp10)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = null,
                )
                Text(
                    modifier = modifier
                        .padding(start = dp3)
                        .align(Alignment.CenterVertically),
                    text = "Action",
                    fontSize = sp17,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetail() {
    MaterialTheme {
        DetailsScreens(
            uiState = DetailsScreenUiState.Success(
                detailsKinofy = InfoKinofyPresentationModel.unknown,
                overview = InfoKinofyPresentationModel.unknown
            )
        )
    }
}