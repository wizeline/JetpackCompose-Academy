package com.wizeline.compose.academy.presentation.ui.screens.util

import com.wizeline.compose.academy.domain.model.Place

sealed class Screen(val route: String) {
    object LandingScreen: Screen("landing_screen")
    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen")
    object GalleryScreen: Screen("image_gallery_screen")
}