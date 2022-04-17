package com.wizeline.compose.academy.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CircleFavorite(
    icon: ImageVector
) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(
                color = Color.White,
                shape = CircleShape
            )
    ) {
        Icon(
            icon,
            contentDescription = "icon",
            modifier = Modifier.padding(5.dp)
        )
    }
}