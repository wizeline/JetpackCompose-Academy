package com.wizeline.compose.academy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class ComposeAcademyScreen(val icon: ImageVector) {
    Landing(
        icon = Icons.Filled.Home
    ),
    Home(
        icon = Icons.Filled.Home
    ),
    Detail(
        icon = Icons.Filled.Favorite
    );

    companion object {
        fun fromRoute(route: String?): ComposeAcademyScreen =
            when (route?.substringBefore("/")) {
                //LandingPage.name -> Landing
                Landing.name -> Landing
                Home.name -> Home
                Detail.name -> Detail
                null -> Landing
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}