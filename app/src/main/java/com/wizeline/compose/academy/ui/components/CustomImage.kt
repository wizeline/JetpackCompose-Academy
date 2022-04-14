package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun FullSizeImage(imageId: Int, description: String){
    val image: Painter = painterResource(id = imageId)
    Image(painter = image,
        contentDescription = description,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
@Preview
fun PreviewCustomImage(){
    ComposeAcademyTheme {
        Surface {
            FullSizeImage(imageId = R.drawable.hotel_image_1,
                description = stringResource(id = R.string.label_place_description)
            )
        }
    }
}
