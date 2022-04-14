package com.wizeline.compose.academy.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.model.Hotel
import com.wizeline.compose.academy.ui.components.CustomCircleButton
import com.wizeline.compose.academy.ui.components.DetailCardContent
import com.wizeline.compose.academy.ui.components.FullSizeImage
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun DetailScreen(hotel: Hotel) {

    val size = LocalConfiguration.current
    val height = size.screenHeightDp * 0.3
    val contentHeight = size.screenHeightDp * 0.73

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Box(modifier = Modifier
            .fillMaxSize()
            .height(height = height.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            FullSizeImage(
                imageId = R.drawable.hotel_image_1,
                description = stringResource(id = R.string.label_hotels),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_large)),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                CustomCircleButton(
                    Icons.Default.ArrowBack,
                )
                CustomCircleButton(
                    Icons.Default.FavoriteBorder
                )
            }
        }
        DetailCardContent(hotel = hotel, Modifier.height(contentHeight.dp))

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
            DetailScreen(hotel = hotel)
        }
    }
}