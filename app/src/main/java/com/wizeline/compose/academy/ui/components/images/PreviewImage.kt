package com.wizeline.compose.academy.ui.components.images

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.models.GalleryImage
import com.wizeline.compose.academy.tools.dp_100
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun PreviewImage(
    image: GalleryImage,
    placeHolder: Int = R.drawable.placeholder
) {
    Image(
        painter = rememberImagePainter(
            data = image.imageUrl,
            builder = {
                placeholder(placeHolder)
            }),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(dp_100),
    )

}

@Preview
@Composable
private fun PreviewImagePreview() {
    ComposeAcademyTheme {
        Surface {
            PreviewImage(
                GalleryImage(2, ""),
                R.drawable.hotel_image_2
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewImageDarkPreview() {
    PreviewImagePreview()
}
