package com.wizeline.compose.academy.ui.widgets.ratingbars

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant
import com.wizeline.compose.academy.ui.theme.PrimaryOrange

@Composable
fun StarsRating(
  rating: Int = 5,
  reviews: Int = 0,
  showLabel: Boolean = false
) {
  Row(
    verticalAlignment = Alignment.CenterVertically
  ) {
    for (index in 1..5) {
      Icon(
        imageVector = Icons.Default.Star,
        contentDescription = "Rating stars",
        tint = if (index >= rating) Color.White else PrimaryOrange
      )
    }
    Text(
      text = when {
        reviews > 0 && showLabel -> "($reviews reviews)"
        reviews > 0 -> "($reviews)"
        else -> ""
      },
      style = MaterialTheme.typography.body2.copy(
        color = PrimaryGravyVariant
      )
    )
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewStarsRating() {
  ComposeAcademyTheme {
    Surface {
      StarsRating()
    }
  }
}