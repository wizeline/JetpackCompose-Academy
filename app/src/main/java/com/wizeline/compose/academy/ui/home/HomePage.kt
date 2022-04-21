package com.wizeline.compose.academy.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.GetPLacesUsecase
import com.wizeline.compose.academy.domain.models.PlaceModel
import com.wizeline.compose.academy.ui.common.CategoryItem
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.Dimens

val tab_options = arrayOf("Hotels", "Things to do", "Events", "Sights")

@Composable
fun HomePage(itemClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(Dimens.ITEM_SEPARATION_NORMAL.size),
        //verticalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            Header()
            SearchBar(){}
            TabsMenu(tab_options)
            PlacesList(itemClick)
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

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
                ){
                    Icon(Icons.Filled.Home, contentDescription = "home button")
                    Text(
                        text = stringResource(id = R.string.label_home),
                        modifier = Modifier.padding(start = Dimens.ITEM_SEPARATION_SMALL.size),
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = Dimens.ITEM_SEPARATION_NORMAL.size),
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(
                        disabledBackgroundColor = Color.Transparent,
                        backgroundColor = Color.Transparent
                    )
                ){
                    Icon(Icons.Filled.AccountBox, contentDescription = "work button")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = Dimens.ITEM_SEPARATION_NORMAL.size),
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(
                        disabledBackgroundColor = Color.Transparent,
                        backgroundColor = Color.Transparent
                    )
                ){
                    Icon(Icons.Filled.Favorite, contentDescription = "like button")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = Dimens.ITEM_SEPARATION_NORMAL.size),
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(
                        disabledBackgroundColor = Color.Transparent,
                        backgroundColor = Color.Transparent
                    )
                ){
                    Icon(Icons.Filled.Person, contentDescription = "profile button")
                }
            }
        }
    }
}

@Composable
fun PlacesList(itemClick: (String) -> Unit) {
    LazyRow() {
        items(GetPLacesUsecase().fetchPlaces()) { placeModel ->
            DestinyItem(
                place = placeModel,
                onClick = itemClick
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
            HomePage() {}
        }
    }
}