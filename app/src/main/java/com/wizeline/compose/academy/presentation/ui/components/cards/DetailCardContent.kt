package com.wizeline.compose.academy.presentation.ui


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.Place
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.components.buttons.CustomButton
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceImageGallery
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceItemAddress
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceItemName
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceItemPrice
import com.wizeline.compose.academy.presentation.ui.components.ranking.Ranking
import com.wizeline.compose.academy.presentation.ui.components.spacer.CustomHeightSpacer
import com.wizeline.compose.academy.presentation.ui.components.tab_list.HorizontalTabList
import com.wizeline.compose.academy.presentation.ui.screens.util.Screen
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.presentation.ui.theme.PrimaryGravyVariant

@Composable
fun DetailCardContent(modifier: Modifier = Modifier,
                      place: Place,
                      navController: NavController){

    val menuList = listOf(stringResource(id = R.string.label_overview), 
                          stringResource(id = R.string.label_details),
                          stringResource(id = R.string.label_costs))
    Card(
        shape = RoundedCornerShape(
            topEnd = dimensionResource(id = R.dimen.twenty),
            topStart = dimensionResource(id = R.dimen.twenty)),
        elevation = dimensionResource(id = R.dimen.zero),
        modifier = modifier
    ) {
        LazyColumn(
            modifier= Modifier.padding(dimensionResource(id = R.dimen.ten))
        ) {
           item {
               CustomHeightSpacer()

               PlaceItemName(name = place.name,
                             style = MaterialTheme.typography.h5)

               CustomHeightSpacer()

               Ranking(showLabel = true, ranking = place.ranking, reviews= place.reviews)

               CustomHeightSpacer()

               PlaceItemAddress(address = place.location)

               CustomHeightSpacer()

               HorizontalTabList(list = menuList)

               CustomHeightSpacer()

               Text(text = place.description, color= PrimaryGravyVariant)

               CustomHeightSpacer()

               IconButton(onClick = { navController.navigate(Screen.GalleryScreen.route + "?id=${place.id}")}) {
                   Row {
                       Text(text = stringResource(id = R.string.label_see_more),
                           color = MaterialTheme.colors.primary,
                           )
                       Icon(Icons.Default.ArrowForward,
                           contentDescription = stringResource(id = R.string.label_see_more),
                           tint= MaterialTheme.colors.primary)
                   }
               }

               CustomHeightSpacer()

               PlaceImageGallery(place.imagesList)

               CustomHeightSpacer()

               Row(modifier= Modifier.fillMaxWidth(),
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.SpaceBetween){
                   PlaceItemPrice(place.price)
                   CustomButton(stringResource(id = R.string.label_availability), navController = rememberNavController())
               }
           }
        }
    }
}

@Preview
@Composable
fun PreviewDetailCardContent(){
    ComposeAcademyTheme {
        Surface {
            DetailCardContent(place = getPlaces()[0], navController = rememberNavController())
        }
    }
}