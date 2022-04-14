package com.wizeline.compose.academy

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.data.dummy.categories
import com.wizeline.compose.academy.data.dummy.hotelList
import com.wizeline.compose.academy.ui.*
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGray

@Composable
fun ExploreScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.label_explore),
                style = MaterialTheme.typography.h4.copy(
                    color = PrimaryGray,
                    fontWeight = FontWeight.Bold
                )
            )

            Icon(Icons.Default.Notifications, contentDescription = "Notifications icon")
        }

        CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

        Text(
            text = stringResource(id = R.string.label_explore_description),
            style = MaterialTheme.typography.body1.copy(color = PrimaryGray)
        )

        CustomHeightSpacer()

        CustomSearchBar()

        CustomHeightSpacer()

        HorizontalTabList(list = listOf("Hotels", "Things to do", "Events", "Sights"))

        CustomHeightSpacer(SpacerHeight.SMALL)

        LazyRow {
            itemsIndexed(hotelList) { _, item ->
                PlaceItemCard(place = item)
            }
        }

        CustomHeightSpacer()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.label_categories),
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = stringResource(id = R.string.label_see_more),
                style = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.primary
                )
            )
        }

        CustomHeightSpacer()

        LazyRow() {
            items(categories) {
                CategoryItemCard(category = it)
            }
        }

    }
}

@Composable
@Preview
fun PreviewExploreScreen() {
    ComposeAcademyTheme {
        Surface {
            ExploreScreen()
        }
    }
}
