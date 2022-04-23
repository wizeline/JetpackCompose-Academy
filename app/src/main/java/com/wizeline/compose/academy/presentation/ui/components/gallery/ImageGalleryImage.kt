package com.wizeline.compose.academy.presentation.ui.components.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun ImageGalleryImage(imageID : Int){
    Image(painter = painterResource(imageID),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(100.dp))
}

@Preview
@Composable
fun PreviewImageGalleryImage(){
    val context = LocalContext.current
    ComposeAcademyTheme {
            ImageGalleryImage(imageID = context.resources.getIdentifier(
                "hotel_gallery",
                "drawable",
                context.packageName
            ))
        }
}