package com.wizeline.compose.academy.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant

@Composable
fun CustomPlaceLocation(location: String, iconTint: androidx.compose.ui.graphics.Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = "location",
            tint = iconTint
        )
        Text(
            text = location,
            style = MaterialTheme.typography.body2.copy(color = PrimaryGravyVariant)
        )
    }
}