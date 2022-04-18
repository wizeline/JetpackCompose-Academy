package com.wizeline.compose.academy.ui.widgets.carousels

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.ui.models.PlaceItem
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.widgets.items.PlacesCardItem

@Composable
fun PlacesCardCarousel(
  items: List<PlaceItem> = emptyList()
) {
  LazyRow {
    items(items) { item ->
      PlacesCardItem(item)
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewPlaceCardCarousel() {
  ComposeAcademyTheme {
    Surface {
      PlacesCardCarousel()
    }
  }
}