package com.wizeline.compose.academy.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant
import com.wizeline.compose.academy.ui.components.icons.CircleIcon
import com.wizeline.compose.academy.ui.components.buttons.CustomButton
import com.wizeline.compose.academy.ui.components.CustomHorizontalTabs
import com.wizeline.compose.academy.ui.components.utils.CustomHeightSpacer
import com.wizeline.compose.academy.ui.home.HotelAddress
import com.wizeline.compose.academy.ui.home.HotelName
import com.wizeline.compose.academy.ui.home.Ranking
import com.wizeline.compose.academy.ui.home.TextPriceByNight

@Composable
fun DetailView() {
    val size = LocalConfiguration.current
    val imageHeight = size.screenHeightDp * 0.3
    val contentHeight = size.screenHeightDp * 0.73

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_image_1),
                    contentDescription = "header_image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleIcon(
                        icon = Icons.Default.ArrowBack
                    )

                    CircleIcon(
                        icon = Icons.Default.FavoriteBorder
                    )
                }
            }
        }

        DetailContent(
            modifier = Modifier
                .fillMaxWidth()
                .height(contentHeight.dp)
        )
    }
}

@Composable
fun PlaceImageGallery() {
    LazyRow {
        items(4) {
            Image(
                painter = painterResource(id = R.drawable.hotel_gallery),
                contentDescription = "place_item_gallery",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .padding(10.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}

@Composable
fun DetailContent(modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(
            topEnd = 20.dp,
            topStart = 20.dp
        ),
        elevation = 0.dp,
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ) {

            item {
                CustomHeightSpacer()

                HotelName(
                    hotelName = "La casa de las tortugas",
                    style = MaterialTheme.typography.h5
                )

                CustomHeightSpacer()

                Ranking(
                    showLabel = true
                )

                CustomHeightSpacer()

                HotelAddress(
                    address = "Av. Damerón, 77310 Isla Holbox, Q.R., México"
                )

                CustomHeightSpacer()

                CustomHorizontalTabs(
                    list = listOf(
                        stringResource(id = R.string.label_overview),
                        stringResource(id = R.string.label_details),
                        stringResource(id = R.string.label_costs)
                    )
                )

                CustomHeightSpacer()

                Text(
                    text = stringResource(id = R.string.label_explore_places_description),
                    color = PrimaryGravyVariant
                )

                CustomHeightSpacer()

                Row {
                    Text(
                        text = stringResource(id = R.string.label_see_more),
                        color = MaterialTheme.colors.primary
                    )

                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "icon",
                        tint = MaterialTheme.colors.primary
                    )
                }

                CustomHeightSpacer()

                PlaceImageGallery()

                CustomHeightSpacer()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextPriceByNight()
                    CustomButton(
                        title = stringResource(id = R.string.label_check_availability)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun DetailViewPreview() {
    ComposeAcademyTheme {
        Surface {
            DetailView()
        }
    }
}