package com.wizeline.compose.academy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.model.Place
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant

@Composable
fun PlaceItemCard(place: Place) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .clip(MaterialTheme.shapes.medium),
        elevation = 15.dp
    ) {
        Column() {
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(place.imageResourceId),
                    contentDescription = "place",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .padding(2.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                )
                CircleIconButton(icon = Icons.Default.FavoriteBorder)
            }

            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
                CustomRanking(place.ranking, place.review, false)

                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                CustomPlaceName(name = place.name)

                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                CustomPlaceLocation(location = place.location, iconTint = PrimaryGravyVariant)

                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                CustomPlacePrice(price = place.price)
            }

        }

    }
}

@Composable
@Preview
fun PreviewPlaceItemCard() {
    ComposeAcademyTheme {
        Surface {
            PlaceItemCard(
                Place(
                    "Casa las tortugas",
                    4,
                    321,
                    "Aomang, Tailand",
                    1260,
                    R.drawable.hotel_image_1
                )
            )
        }
    }
}