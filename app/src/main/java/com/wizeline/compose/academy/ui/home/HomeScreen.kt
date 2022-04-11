package com.wizeline.compose.academy.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.models.Category
import com.wizeline.compose.academy.data.models.Place
import com.wizeline.compose.academy.domain.DataGenerator
import com.wizeline.compose.academy.ui.components.common.HorizontalTabList
import com.wizeline.compose.academy.ui.components.common.SearchBar
import com.wizeline.compose.academy.ui.components.category.CategoryItem
import com.wizeline.compose.academy.ui.components.common.CustomSpacer
import com.wizeline.compose.academy.ui.components.place.PlaceItemCard
import com.wizeline.compose.academy.ui.extensions.defaultScreen
import com.wizeline.compose.academy.ui.extensions.getGrayColor
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGray
import com.wizeline.compose.academy.ui.theme.dimen_10dp

@Composable
fun HomeScreen() {
    LazyColumn(modifier = Modifier.defaultScreen()) {
        item {
            HomeHeader()

            CustomSpacer()

            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                value = ""
            ) {}
            CustomSpacer()

            HorizontalTabList(
                list = listOf(
                    stringResource(id = R.string.label_hotels),
                    stringResource(id = R.string.label_things_to_do),
                    stringResource(id = R.string.label_events),
                    stringResource(id = R.string.label_sights)
                )
            )
            CustomSpacer()

            HomePlacesList(
                list = DataGenerator.placeList
            )
            CustomSpacer()

            HomeCategories(
                list = DataGenerator.categoryList
            )
        }
    }
}

@Composable
private fun HomePlacesList(
    list: List<Place>
) {
    LazyRow {
        items(list) { place ->
            PlaceItemCard(place)
        }
    }
}

@Composable
private fun HomeHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.label_explore),
            style = MaterialTheme.typography.h4.copy(
                color = getGrayColor(),
                fontWeight = FontWeight.Bold
            )
        )

        Icon(
            Icons.Default.Notifications,
            contentDescription = "notifications",
            tint = getGrayColor()
        )
    }

    Text(
        text = stringResource(id = R.string.label_explore_description),
        style = MaterialTheme.typography.body1.copy(
            color = getGrayColor()
        )
    )
}


@Composable
private fun HomeCategories(
    list: List<Category>
) {
    HomeSection(
        section = stringResource(id = R.string.label_categories),
        actionText = stringResource(id = R.string.label_see_more)
    ) {}

    CustomSpacer()

    LazyRow {
        items(list) { category ->
            CategoryItem(
                category = category
            )
        }
    }
}

@Composable
private fun HomeSection(
    modifier: Modifier = Modifier,
    section: String,
    hasActions: Boolean = true,
    actionText: String = stringResource(id = R.string.label_empty),
    onActionClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimen_10dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = section,
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.Bold
            )
        )
        if (hasActions) {
            Text(
                text = actionText,
                style = MaterialTheme.typography.body2.copy(
                    color = MaterialTheme.colors.primary
                ),
                modifier = Modifier.clickable { onActionClick() }
            )
        }
    }
}


@Composable
@Preview(name = "light_mode")
@Preview(name = "dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewHomeScreen() {
    ComposeAcademyTheme {
        Surface {
            HomeScreen()
        }
    }
}
