package com.wizeline.compose.academy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.widgets.custom.CustomSpacer

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

    Box(modifier = Modifier.padding(10.dp)) {
      Column(
        modifier = Modifier
          .background(color = Color.White)
          .padding(5.dp)
      ) {

        Image(
          painter = painterResource(id = R.drawable.hotel_gallery_2),
          contentDescription = null,
          contentScale = ContentScale.Crop,
          modifier = Modifier.size(100.dp)
        )

        CustomSpacer()

        Image(
          painter = painterResource(id = R.drawable.hotel_gallery_3),
          contentDescription = null,
          contentScale = ContentScale.Crop,
          modifier = Modifier.size(100.dp)
        )

        CustomSpacer()

        Image(
          painter = painterResource(id = R.drawable.hotel_gallery),
          contentDescription = null,
          contentScale = ContentScale.Crop,
          modifier = Modifier.size(100.dp)
        )
      }
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewImageGalleryScreen() {
  ComposeAcademyTheme {
    androidx.compose.material.Surface {
      ImageGalleryScreen()
    }
  }
}