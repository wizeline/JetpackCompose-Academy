package com.wizeline.compose.academy.ui.screens.gallery

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.models.GalleryImage
import com.wizeline.compose.academy.tools.dp_10
import com.wizeline.compose.academy.tools.dp_5
import com.wizeline.compose.academy.ui.components.images.PreviewImage
import com.wizeline.compose.academy.ui.components.others.CustomWidthSpacer
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun ImageGalleryScreen(
    images: List<GalleryImage>,
    placeHolder: Int = R.drawable.placeholder
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd,
    ) {
        Image(
            painter = rememberImagePainter(
                data = images[0].imageUrl,
                builder = {
                    placeholder(placeHolder)
                }),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        Box(modifier = Modifier.padding(dp_10)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White
                    )
                    .padding(dp_5),
            ) {

                //for (i in images) {
                LazyRow {
                    itemsIndexed(images) { _, item ->
                        CustomWidthSpacer()

                        PreviewImage(image = item, placeHolder)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ImageGalleryScreenPreview() {
    ComposeAcademyTheme {
        Surface {
            ImageGalleryScreen(
                listOf(
                    GalleryImage(1, ""),
                    GalleryImage(2, ""),
                    GalleryImage(3, "")
                ),
                R.drawable.hotel_gallery_3
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ImageGalleryScreenDarkPreview() {
    ImageGalleryScreenPreview()
}
