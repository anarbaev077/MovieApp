package com.example.movieapp.presentation.components.different_screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.components.tab_row.TabRowItem
import com.example.movieapp.presentation.models.models.KinofyPresentationModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun KinofyList(
    kinoList: ImmutableList<KinofyPresentationModel>
) {
    LazyRow(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        items(items = kinoList, key = { it.kinofyesIds }) {
            TabRowItem(imageUrl = it.poster)
        }
    }
}