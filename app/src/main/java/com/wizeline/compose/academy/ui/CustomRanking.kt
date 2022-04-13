package com.wizeline.compose.academy.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant
import com.wizeline.compose.academy.ui.theme.PrimaryGray
import com.wizeline.compose.academy.ui.theme.PrimaryOrange

@Composable
fun CustomRanking(ranking: Int, reviews: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        for (i in 1..5) {
            val starOn = (i <= ranking)
            Icon(
                Icons.Default.Star,
                contentDescription = "Ranking",
                tint = if (starOn) PrimaryOrange else PrimaryGray
            )
        }
        Text(
            text = "(${reviews})",
            style = MaterialTheme.typography.body2.copy(color = PrimaryGravyVariant)
        )
    }
}