package com.example.movieapp.presentation.components.different_screens

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.movieapp.presentation.components.tab_rows.for_main_screen.TopRated
import com.example.movieapp.presentation.models.base_models.KinofyPresentationModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun KinofyList(
    kinoList: ImmutableList<KinofyPresentationModel>
) {
    LazyRow{
        items(items = kinoList, key = { it.kinofyesIds }) {
            TopRated(
                imageUrl = it.poster,
                model = it,
                onNavigateToInfo = {}
            )
        }
    }
}