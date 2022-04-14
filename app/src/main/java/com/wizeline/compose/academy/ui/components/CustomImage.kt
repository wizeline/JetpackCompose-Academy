package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun CustomImage(imageId: Int, description: String, modifier: Modifier){
    val image: Painter = painterResource(id = imageId)
    Image(painter = image,
        contentDescription = description,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}