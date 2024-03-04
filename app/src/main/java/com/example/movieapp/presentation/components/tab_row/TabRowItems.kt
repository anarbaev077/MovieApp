package com.example.movieapp.presentation.components.tab_row

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp180
import com.example.movieapp.presentation.theme.dp20
import com.example.movieapp.presentation.theme.dp22
import com.example.movieapp.presentation.theme.dp230

@SuppressLint("ResourceType")
@Composable
fun TabRowItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
) {
    Box(
        modifier = modifier
            .padding(dp10)
            .height(dp230)
            .width(dp180)
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(dp22)
                .fillMaxSize()
                .clip(RoundedCornerShape(dp20)),
            model = Constants.POSTER + imageUrl,
            placeholder = painterResource(id = R.drawable.loading_icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}