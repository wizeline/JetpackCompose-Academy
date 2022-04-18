package com.wizeline.compose.academy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.widgets.buttons.CircleIconButton
import com.wizeline.compose.academy.ui.widgets.custom.PlacesCardWithAvailability

@Composable
fun DetailScreen() {

  val configuration = LocalConfiguration.current
  // Value for the 30 percent of the height of the screen
  val height = configuration.screenHeightDp * 0.3
  // Value for the 73 percent of the height
  val contentHeight = configuration.screenHeightDp * 0.73

  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.BottomCenter
  ) {

    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Companion.TopCenter
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(height.dp),
        contentAlignment = Alignment.TopCenter
      ) {
        Image(
          painter = painterResource(id = R.drawable.hotel_image_1),
          contentDescription = "Card header",
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxWidth()
        )
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          CircleIconButton(icon = Icons.Default.ArrowBack)
          CircleIconButton(icon = Icons.Default.FavoriteBorder)
        }
      }
    }

    PlacesCardWithAvailability(
      modifier = Modifier
        .fillMaxWidth()
        .height(contentHeight.dp)
    )
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewDetailScreen() {
  ComposeAcademyTheme {
    Surface {
      DetailScreen()
    }
  }
}