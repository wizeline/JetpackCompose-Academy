package com.wizeline.compose.academy.ui.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.components.utils.CustomWidthSpacer
import com.wizeline.compose.academy.ui.components.utils.SpacerSize
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun GalleryView() {
    val screen = LocalConfiguration.current
    val mainImageSize = screen.screenHeightDp * 0.8
    val imagesGallerySize = screen.screenHeightDp * 0.2

    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.hotel_gallery),
            contentDescription = "main_image",
            modifier = Modifier
                .fillMaxWidth()
                .height(mainImageSize.dp),
            contentScale = ContentScale.Inside
        )

        LazyRow(
            modifier = Modifier
                .height(imagesGallerySize.dp)
        ) {
            item {
                Row {
                    ImageBox(
                        painter = painterResource(id = R.drawable.hotel_gallery)
                    )

                    ImageBox(
                        painter = painterResource(id = R.drawable.hotel_gallery_2)
                    )

                    ImageBox(
                        painter = painterResource(id = R.drawable.hotel_gallery_3)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageBox(painter: Painter) {
    CustomWidthSpacer(
        spacerSize = SpacerSize.EXTRA_SMALL
    )

    Image(
        painter = painter,
        contentDescription = "image_gallery"
    )

    CustomWidthSpacer(
        spacerSize = SpacerSize.EXTRA_SMALL
    )
}

@Composable
@Preview
fun GalleryViewPreview() {
    ComposeAcademyTheme {
        Surface {
            GalleryView()
        }
    }
}