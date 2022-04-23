package com.wizeline.compose.academy.presentation.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.getCategories
import com.wizeline.compose.academy.presentation.ui.theme.PrimaryGray
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.components.cards.CategoryItemCard
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceItemCard
import com.wizeline.compose.academy.presentation.ui.components.search_bar.SearchBar
import com.wizeline.compose.academy.presentation.ui.components.spacer.CustomHeightSpacer
import com.wizeline.compose.academy.presentation.ui.components.spacer.SpacerHeight
import com.wizeline.compose.academy.presentation.ui.components.tab_list.HorizontalTabList
import com.wizeline.compose.academy.presentation.ui.extensions.defaultScreen
import com.wizeline.compose.academy.presentation.ui.screens.gallery.ImageGalleryScreen
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun HomeScreen(navController: NavController){

    val menuList = listOf(stringResource(id = R.string.label_hotels),
                          stringResource(id = R.string.label_things_to_do),
                          stringResource(id = R.string.label_events),
                          stringResource(id = R.string.label_sights)
    )

    val placesList = getPlaces()
    val categoriesList = getCategories()

    Column(modifier= Modifier.fillMaxSize()
        .padding(20.dp)) {
        Row(modifier= Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
               Text(text = stringResource(id = R.string.label_explore),
                    style = MaterialTheme.typography.h4.copy(
                       color= PrimaryGray,
                       fontWeight = FontWeight.Bold))

               Icon(Icons.Default.Notifications,
                    contentDescription = stringResource(id = R.string.label_notifications),
                    tint = PrimaryGray)
            }

        CustomHeightSpacer()

        Text(text = stringResource(id = R.string.label_explore_description),
            style = MaterialTheme.typography.body1.copy(
                color= PrimaryGray))

        CustomHeightSpacer()

        SearchBar()

        HorizontalTabList(list = menuList)

        LazyColumn{

            item{
                LazyRow {
                    itemsIndexed(placesList){ _, item ->
                        PlaceItemCard(item, navController)
                    }
                }
                CustomHeightSpacer(spacerHeight = SpacerHeight.MEDIUM)
                Row(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.ten)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text= stringResource(id = R.string.label_categories),
                        style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.Bold
                        ))
                    Text(
                        text= stringResource(id = R.string.label_see_more),
                        style = MaterialTheme.typography.body2.copy(
                            color= MaterialTheme.colors.primary
                        )
                    )
                }
                LazyRow {
                    itemsIndexed(categoriesList){ _, item ->
                        CategoryItemCard(item)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    ComposeAcademyTheme() {
        Surface {
            HomeScreen(rememberNavController())
        }
    }
}