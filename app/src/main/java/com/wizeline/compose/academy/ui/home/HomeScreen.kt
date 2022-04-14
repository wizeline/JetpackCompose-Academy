package com.wizeline.compose.academy.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.model.Category
import com.wizeline.compose.academy.data.model.Hotel
import com.wizeline.compose.academy.ui.components.*
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme


@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(dimensionResource(id = R.dimen.padding_medium)),

        ) {
        item {
            CustomHeightSpacer(SpacerSize.EXTRA_LARGE)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.label_explore),
                    style = MaterialTheme.typography.h2

                )
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
            CustomHeightSpacer(SpacerSize.SMALL)
            Text(
                text = stringResource(id = R.string.label_explore_description),
                style = MaterialTheme.typography.h5
            )
            CustomHeightSpacer(SpacerSize.MEDIUM)
            Row(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_medium),
                    end = dimensionResource(id = R.dimen.padding_medium)
                )
            ) {
                SearchBarComponent()
            }
            CustomHeightSpacer(SpacerSize.LARGE)
            Row {
                HorizontalTextTab(titles = listOf("Hotels", "Things to do", "Events", "Sights"))
            }
            CustomHeightSpacer(SpacerSize.LARGE)

            val hotels = listOf(
                Hotel(
                    name = stringResource(id = R.string.hotel_name_sample),
                    address = stringResource(id = R.string.addres_sample_2),
                    stars = 1,
                    price = 910,
                    reviews = 50,
                    image = R.drawable.hotel_image,
                    description = stringResource(id = R.string.label_place_description)
                ),
                Hotel(
                    name = stringResource(id = R.string.hotel_name_sample_2),
                    address = stringResource(id = R.string.addres_sample_2),
                    stars = 3,
                    price = 1620,
                    reviews = 700,
                    image = R.drawable.hotel_image_2,
                    description = stringResource(id = R.string.label_place_description)
                )
            )

            LazyRow {
                items(hotels) { hotel ->
                    PlaceItem(hotel = hotel)
                }
            }
            CustomHeightSpacer(SpacerSize.SMALL)
            Text(
                text = stringResource(id = R.string.label_categories),
                style = MaterialTheme.typography.h4
            )
            LazyRow {
                val categories = listOf(
                    Category(R.drawable.mountain, "Mountain", "This is a mountain"),
                    Category(R.drawable.beach, "Beach", "This is a beach"),
                    Category(R.drawable.forest, "Forest", "This is a forest")

                )
                items(categories) { category ->
                    CategoryItem(category)
                }
            }
        }


    }
}

@Composable
@Preview
fun PreviewHomeScreen() {
    ComposeAcademyTheme {
        Surface {
            HomeScreen()
        }
    }
}
