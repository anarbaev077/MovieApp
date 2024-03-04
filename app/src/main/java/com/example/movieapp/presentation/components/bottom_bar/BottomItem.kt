package com.example.movieapp.presentation.components.bottom_bar

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomItem(
    val title: String,
    val unselectedIcon: Painter,
    val selectedIcon: ImageVector,

    )