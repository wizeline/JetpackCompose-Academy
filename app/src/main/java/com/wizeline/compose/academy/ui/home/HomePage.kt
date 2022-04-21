package com.wizeline.compose.academy.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.GetPLacesUsecase
import com.wizeline.compose.academy.ui.common.CategoryItem
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.Dimens

val tab_options = arrayOf("Hotels", "Things to do", "Events", "Sights")

@Composable
fun HomePage() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(Dimens.ITEM_SEPARATION_NORMAL.size),
        //verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header()
        SearchBar(){}
        TabsMenu(tab_options)
        PlacesList()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
           Text(
               text = stringResource(id = R.string.label_categories),
               style = MaterialTheme.typography.h4.copy(
                   fontWeight = FontWeight.SemiBold
               )
           )
            Text(
                text = stringResource(id = R.string.label_see_more),
                style = MaterialTheme.typography.h6.copy(
                    color = MaterialTheme.colors.primary
                )
            )
        }
        LazyRow {
            for (index in 0 until 3) {
                item { 
                    CategoryItem(index = index)
                }
            }
        }
    }
}

@Composable
fun PlacesList() {
    LazyRow() {
        items(GetPLacesUsecase().fetchPlaces()) { placeModel ->
            DestinyItem(
                place = placeModel
            )
        }
    }
}

@Composable
fun Header() {
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
            Icons.Default.Notifications,
            contentDescription = "notifications",
            tint = Color.Gray
        )
    }
    Text(
        text = stringResource(id = R.string.label_explore_description),
        style = MaterialTheme.typography.body2.copy(
            fontWeight = FontWeight.SemiBold
        ),
        modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_SMALL.size)
    )
}


@Preview
@Composable
fun PreviewHomePage() {
    ComposeAcademyTheme {
        Surface {
            HomePage()
        }
    }
}