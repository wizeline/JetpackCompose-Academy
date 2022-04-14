package com.wizeline.compose.academy.ui.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.components.CustomHeightSpacer
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme


@Composable
fun ImageGalleryScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.hotel_gallery),
            contentDescription = stringResource(id = R.string.label_place_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()

        )
        Box(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            Column(modifier = Modifier
                .background(color = Color.White)
                .padding(dimensionResource(id = R.dimen.padding_small))) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_gallery_2),
                    contentDescription = stringResource(id = R.string.label_place_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.image_gallery_size))
                )
                CustomHeightSpacer()
                Image(
                    painter = painterResource(id = R.drawable.hotel_gallery_3),
                    contentDescription = stringResource(id = R.string.label_place_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.image_gallery_size))
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewImageGallery() {
    ComposeAcademyTheme {
        Surface {
            ImageGalleryScreen()
        }
    }
}