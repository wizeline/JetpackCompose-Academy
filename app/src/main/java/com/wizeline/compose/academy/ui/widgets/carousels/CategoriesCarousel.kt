package com.wizeline.compose.academy.ui.widgets.carousels

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.ui.models.CategoriesItem
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.widgets.items.CategoryItem

@Composable
fun CategoriesCarousel(
  categories: List<CategoriesItem> = emptyList()
) {
  LazyRow {
    items(categories) { category ->
      CategoryItem(category)
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewCategoriesCarousel() {
  ComposeAcademyTheme {
    Surface {
      CategoriesCarousel()
    }
  }
}