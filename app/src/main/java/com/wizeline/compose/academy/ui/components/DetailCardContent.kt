package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.model.Hotel
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryBlue

@Composable
fun DetailCardContent(hotel: Hotel, modifier: Modifier) {
    Card(
        modifier = modifier,
        shape = AbsoluteRoundedCornerShape(
            topLeft = dimensionResource(id = R.dimen.rounded_xlarge),
            topRight = dimensionResource(id = R.dimen.rounded_xlarge),
        ), elevation = dimensionResource(id = R.dimen.zero_elevation)
    ) {
        LazyColumn(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
        ) {
            item {
                Text(
                    text = hotel.name,
                    style = MaterialTheme.typography.h4
                )
                CustomHeightSpacer(SpacerSize.SMALL)
                Rating(hotel.stars, hotel.reviews)
                CustomHeightSpacer(SpacerSize.SMALL)
                AddressComponent(true)
                CustomHeightSpacer(SpacerSize.SMALL)
                HorizontalTextTab(
                    titles = listOf(
                        stringResource(id = R.string.label_overview),
                        stringResource(id = R.string.label_details),
                        stringResource(id = R.string.label_costs)
                    )
                )
                CustomHeightSpacer(SpacerSize.SMALL)
                Text(
                    text = hotel.description,
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.Gray
                    )
                )
                CustomHeightSpacer(SpacerSize.SMALL)
                Row {
                    Text(
                        text = stringResource(id = R.string.label_see_more),
                        style = MaterialTheme.typography.h6.copy(
                            color = PrimaryBlue
                        )
                    )
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = stringResource(id = R.string.label_icon),
                        tint = MaterialTheme.colors.primary
                    )
                }
                PlaceImageGallery()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextPriceComponent(
                        modifier = Modifier,
                        price = hotel.price
                    )

                    CustomButton(
                        title = stringResource(id = R.string.check_availability),
                        modifier = Modifier,
                        onClick = {}
                    )
                }
            }

        }
    }
}

@Composable
@Preview
fun PreviewDetailScreen() {
    val hotel = Hotel(
        name = stringResource(id = R.string.hotel_name_sample_2),
        address = stringResource(id = R.string.addres_sample_2),
        stars = 3,
        price = 1620,
        reviews = 700,
        image = R.drawable.hotel_image_2,
        description = stringResource(id = R.string.label_place_description)
    )
    ComposeAcademyTheme {
        Surface {
            DetailCardContent(hotel = hotel, modifier = Modifier)
        }
    }
}