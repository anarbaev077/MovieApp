package com.example.movieapp.presentation.components.tab_rows.for_main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.links.Links
import com.example.movieapp.presentation.models.base_models.KinofyPresentationModel
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp180
import com.example.movieapp.presentation.theme.dp2
import com.example.movieapp.presentation.theme.dp20
import com.example.movieapp.presentation.theme.dp22
import com.example.movieapp.presentation.theme.dp230
import com.example.movieapp.presentation.theme.dp250

@SuppressLint("ResourceType")
@Composable
fun TopRated(
    modifier: Modifier = Modifier,
    imageUrl: String,
    model: KinofyPresentationModel,
    onNavigateToInfo: (Int) -> Unit,
) {
    val voteAverage = (model.voteAverage).toInt()
    Box(
        modifier = modifier
            .padding(dp10)
            .height(dp250)
            .width(dp250)
            .clickable { onNavigateToInfo (0) }
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(dp2)
                .fillMaxSize()
                .clip(RoundedCornerShape(dp20)),
            model = Links.POSTER + imageUrl,
            placeholder = painterResource(id = R.drawable.loading_icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        if (model.taitl.length > 14) {
            val firstPart = model.taitl.take(14)
            val secondPart = model.taitl.drop(14)

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(firstPart)
                        append("\n")
                        append(secondPart)
                    }
                },
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 7.dp)
                    .fillMaxWidth()
            )
        } else {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 7.dp),
                text = model.taitl,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Icon(
                modifier = modifier.size(20.dp),
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(0xFFE57734)
            )
            Text(
                modifier = modifier
                    .fillMaxSize()
                    .align(Alignment.CenterVertically),
                text = "$voteAverage",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp,
                fontWeight = FontWeight.Black
            )
            Text(
                modifier = modifier.padding(top = 1.dp, start = 1.dp),
                text = stringResource(R.string.again),
                color = Color(0xFF2B124C),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
            )
        }
    }
}