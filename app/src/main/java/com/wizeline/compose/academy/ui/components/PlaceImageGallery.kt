package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun PlaceImageGallery() {
    LazyRow {
        items(4) {
            Image(
                painter = painterResource(id = R.drawable.hotel_image_1),
                contentDescription = stringResource(id = R.string.label_place_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.detail_hotel_image_size))
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}

@Composable
@Preview
fun PreviewPlaceImageGallery() {
    ComposeAcademyTheme {
        Surface {
            PlaceImageGallery()
        }
    }
}