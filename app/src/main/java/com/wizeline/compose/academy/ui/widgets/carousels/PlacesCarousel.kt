package com.wizeline.compose.academy.ui.widgets.carousels

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun PlacesCarousel() {
  LazyRow {
    items(4) { index ->
      val imageId = when (index) {
        1 -> R.drawable.hotel_gallery_2
        2 -> R.drawable.hotel_gallery_3
        else -> R.drawable.hotel_gallery
      }
      Image(
        painter = painterResource(id = imageId),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .size(200.dp)
          .padding(10.dp)
          .clip(MaterialTheme.shapes.medium)
      )
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewPlacesCarousel() {
  ComposeAcademyTheme {
    androidx.compose.material.Surface {
      PlacesCarousel()
    }
  }
}
