package com.example.movieapp.presentation.components.item


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.links.Links

@Composable@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceType")
fun KinofyItem(
    image: String,
    kinofyId: Int,
    modifier: Modifier = Modifier,
    onNavigateToInfo: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .height(170.dp)
            .width(160.dp)
            .clickable { onNavigateToInfo(kinofyId) }
    ) {
        Scaffold {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(14.dp)),
                model = Links.POSTER + image,
                placeholder = painterResource(id = R.drawable.loading_icon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun TabRowItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .height(240.dp)
            .width(170.dp)
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(18.dp)),
                model = Links.POSTER + imageUrl,
                placeholder = painterResource(id = R.drawable.loading_icon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview
@Composable
fun ItemPreview() {
    KinofyItem(
        image = "",
        kinofyId = 0,
        onNavigateToInfo = {}
    )
}