package com.wizeline.compose.academy.presentation.ui.components.place

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.Place
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.components.buttons.CircleIconButton
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceItemAddress
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceItemName
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceItemPrice
import com.wizeline.compose.academy.presentation.ui.components.ranking.Ranking
import com.wizeline.compose.academy.presentation.ui.components.spacer.CustomHeightSpacer
import com.wizeline.compose.academy.presentation.ui.components.spacer.SpacerHeight
import com.wizeline.compose.academy.presentation.ui.screens.util.Screen
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlaceItemCard(place: Place,
                  navController: NavController){

    Card(
        modifier= Modifier.padding(dimensionResource(id = R.dimen.five)),
        shape= MaterialTheme.shapes.medium,
        elevation = dimensionResource(id = R.dimen.five),
        onClick = {
            navController.navigate(Screen.DetailScreen.route +
                "?id=${place.id}"
            )
        }
    ){
        Column() {
            Box(contentAlignment = Alignment.TopEnd){
                Image(
                    painter = painterResource(place.imageId),
                    contentDescription = stringResource(id = R.string.label_hotel),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.two_hundred))
                        .width(dimensionResource(id = R.dimen.two_hundred_fifty))
                        .padding(dimensionResource(id = R.dimen.five))
                        .clip(MaterialTheme.shapes.medium)
                )
                CircleIconButton(icon = Icons.Default.FavoriteBorder,navController)
            }

            Column(
                modifier= Modifier.padding(horizontal = dimensionResource(id = R.dimen.fifteen),
                                             vertical = dimensionResource(id = R.dimen.eight))
            ) {
                CustomHeightSpacer(spacerHeight = SpacerHeight.EXTRA_SMALL)

                Ranking(place.ranking, place.reviews)

                CustomHeightSpacer(spacerHeight = SpacerHeight.EXTRA_SMALL)

                PlaceItemName(place.name)

                CustomHeightSpacer(spacerHeight = SpacerHeight.EXTRA_SMALL)

                PlaceItemAddress(place.location)

                CustomHeightSpacer(spacerHeight = SpacerHeight.EXTRA_SMALL)

                PlaceItemPrice(place.price)
            }
        }
    }
}

@Preview
@Composable
fun PreviewPlaceItemCard(){
    ComposeAcademyTheme {
        Surface{
            PlaceItemCard(place = getPlaces()[0], navController = rememberNavController())
        }
    }
}