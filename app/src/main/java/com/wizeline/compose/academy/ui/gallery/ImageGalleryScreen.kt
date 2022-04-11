package com.wizeline.compose.academy.ui.gallery

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.DataGenerator
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.dimen_100dp
import com.wizeline.compose.academy.ui.theme.dimen_10dp
import com.wizeline.compose.academy.ui.theme.dimen_5dp

@Composable
fun ImageGalleryScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.hotel_gallery),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier.padding(dimen_10dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(color = MaterialTheme.colors.surface)
                    .padding(dimen_5dp)
            ) {
                items(DataGenerator.imageGalleryList) {
                    ImageGalleryItem(
                        painterResource(id = it)
                    )
                }
            }
        }
    }
}

@Composable
private fun ImageGalleryItem(
    image: Painter
) {
    Image(
        painter = image,
        contentDescription = image.toString(),
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(dimen_100dp)
    )
}

@Composable
@Preview(name = "light_mode")
@Preview(name = "dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewImageGalleryScreen() {
    ComposeAcademyTheme {
        Surface {
            ImageGalleryScreen()
        }
    }
}
