package com.wizeline.compose.academy.ui.screens

import android.content.Context
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.models.CategoriesItem
import com.wizeline.compose.academy.ui.models.PlaceItem
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.widgets.carousels.CategoriesCarousel
import com.wizeline.compose.academy.ui.widgets.carousels.PlacesCardCarousel
import com.wizeline.compose.academy.ui.widgets.custom.CustomSearchBar
import com.wizeline.compose.academy.ui.widgets.custom.CustomSpacer
import com.wizeline.compose.academy.ui.widgets.custom.TabLayout

@Composable
fun HomeScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(12.dp)
      .verticalScroll(ScrollState(0))
  ) {

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {

      Text(
        text = stringResource(id = R.string.label_explore),
        style = MaterialTheme.typography.h4.copy(
          fontWeight = FontWeight.Bold
        )
      )

      Icon(
        imageVector = Icons.Default.Notifications,
        contentDescription = "",
        tint = Color.Gray,
        modifier = Modifier.size(30.dp)
      )
    }

    CustomSpacer()

    Text(
      text = stringResource(id = R.string.label_explore_description)
    )

    CustomSpacer()

    CustomSearchBar(elevation = 15.dp)

    CustomSpacer()

    TabLayout(
      items = listOf("Hotels", "Things to do", "Events", "Sights", "Recommendations")
    )

    CustomSpacer()

    PlacesCardCarousel(items = getPlaces(LocalContext.current).toMutableStateList())

    CustomSpacer()

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "Categories",
        style = MaterialTheme.typography.h6.copy(
          fontWeight = FontWeight.Bold
        )
      )
      Text(
        text = "See more",
        style = MaterialTheme.typography.body2.copy(
          color = MaterialTheme.colors.primary
        )
      )
    }

    CustomSpacer()

    CategoriesCarousel(categories = getCategories(LocalContext.current))
  }
}

private fun getPlaces(context: Context) = listOf(
  PlaceItem(
    name = context.getString(R.string.label_places_card_one),
    address = context.getString(R.string.label_places_address_card_one),
    price = 1690.0,
    image = R.drawable.hotel_image_1
  ),
  PlaceItem(
    name = context.getString(R.string.label_places_card_two),
    address = context.getString(R.string.label_places_address_card_two),
    price = 2350.50,
    image = R.drawable.hotel_image_2
  )
)

private fun getCategories(context: Context) = listOf(
  CategoriesItem(
    name = context.getString(R.string.label_mountains),
    image = R.drawable.mountain
  ),
  CategoriesItem(
    name = context.getString(R.string.label_beach),
    image = R.drawable.beach
  ),
  CategoriesItem(
    name = context.getString(R.string.label_forest),
    image = R.drawable.forest
  )
)

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
  ComposeAcademyTheme {
    Surface {
      HomeScreen()
    }
  }
}