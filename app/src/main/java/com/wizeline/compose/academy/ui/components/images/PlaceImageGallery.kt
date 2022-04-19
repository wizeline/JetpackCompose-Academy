package com.wizeline.compose.academy.ui.components.images

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.models.GalleryImage
import com.wizeline.compose.academy.tools.dp_10
import com.wizeline.compose.academy.tools.dp_200
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun PlaceImageGallery(
    images: List<GalleryImage>,
    placeHolder: Int = R.drawable.placeholder
) {
    LazyRow {
        itemsIndexed(images) { _, item ->
            Image(
                painter = rememberImagePainter(
                    data = item.imageUrl,
                    builder = {
                        placeholder(placeHolder)
                    }),
                contentDescription = stringResource(id = R.string.placeItemGalleryDescription),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dp_200)
                    .padding(dp_10)
                    .clip(MaterialTheme.shapes.medium),
            )
        }
    }
}

@Preview
@Composable
private fun PlaceImageGalleryPreview() {
    ComposeAcademyTheme {
        Surface {
            PlaceImageGallery(
                listOf(
                    GalleryImage(
                        1,
                        ""
                    ),
                    GalleryImage(
                        2,
                        ""
                    ),
                    GalleryImage(
                        3,
                        ""
                    ),
                    GalleryImage(
                        4,
                        ""
                    ),
                ),
                R.drawable.hotel_gallery_3
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PlaceImageGalleryDarkPreview() {
    PlaceImageGalleryPreview()
}
