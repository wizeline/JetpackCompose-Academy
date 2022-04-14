package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.model.Hotel
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme


@Composable
fun PlaceItem(hotel: Hotel){
    Card(
        modifier = Modifier.padding(5.dp),
        shape =  RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        Column{
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = hotel.image),
                    contentDescription = stringResource(id = R.string.label_place_description),
                    modifier = Modifier
                        .width(
                            dimensionResource(id = R.dimen.place_item_image_width)
                        )
                        .height(dimensionResource(id = R.dimen.place_item_image_height))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_large))),
                    contentScale = ContentScale.Crop,
                )
                CustomCircleButton(
                    icon = Icons.Outlined.FavoriteBorder
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
            ) {
                CustomHeightSpacer(SpacerSize.SMALL)
                Rating(hotel.stars, hotel.reviews)
                CustomHeightSpacer(SpacerSize.SMALL)
                Text(
                    text = hotel.name,
                    style = MaterialTheme.typography.h5.copy(

                    )
                )
                CustomHeightSpacer(SpacerSize.SMALL)
                AddressComponent()
                CustomHeightSpacer(SpacerSize.SMALL)
                TextPriceComponent(price = hotel.price, time = "night" )
            }
        }

    }
}

@Composable
@Preview
fun PreviewPlaceItem(){
    ComposeAcademyTheme {
        Surface {
            val hotel =  Hotel(
                name = stringResource(id = R.string.hotel_name_sample),
                address = stringResource(id = R.string.addres_sample_2),
                stars = 2,
                price = 1620,
                reviews = 250,
                image = R.drawable.hotel_image,
                description = stringResource(id = R.string.label_place_description)
            )
            PlaceItem(hotel = hotel)
        }
    }
}