package com.wizeline.compose.academy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.common.CircleIconButton
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun ImageGalleryScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {

        Image(
            painter = painterResource(id = R.drawable.hotel_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier.fillMaxSize()
        ) {
            CircleIconButton(icon = Icons.Filled.ArrowBack)
        }

        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
                .background(
                    color = Color.White.copy(
                        alpha = 0.6f
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            items(3) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_image_2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}


@Composable
@Preview
fun PreviewImageGalleryScreen() {
    ComposeAcademyTheme {
        Surface {
            ImageGalleryScreen()
        }
    }
}
