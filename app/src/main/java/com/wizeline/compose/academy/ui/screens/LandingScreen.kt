package com.wizeline.compose.academy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.R.string
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.widgets.buttons.CustomButton
import com.wizeline.compose.academy.ui.widgets.custom.CustomSpacer

@Composable
fun LandingScreen() {
  Box(modifier = Modifier.fillMaxSize()) {

    Image(
      painter = painterResource(id = R.drawable.landing),
      contentDescription = "",
      contentScale = ContentScale.Crop,
      modifier = Modifier.fillMaxSize()
    )

    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
      verticalArrangement = Arrangement.Bottom
    ) {

      Text(
        text = stringResource(id = R.string.label_explore_places),
        style = MaterialTheme.typography.h4.copy(
          color = Color.White,
          fontWeight = FontWeight.Bold
        )
      )

      CustomSpacer()

      Text(
        text = stringResource(id = R.string.label_explore_places_description),
        style = MaterialTheme.typography.body1.copy(color = Color.White)
      )

      CustomSpacer()

      CustomButton(
        string.label_sign_in,
        modifier = Modifier.fillMaxWidth()
      )

      CustomSpacer()

      Text(
        text = stringResource(id = R.string.label_create_account),
        color = Color.White,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewLandingScreen() {
  ComposeAcademyTheme {
    LandingScreen()
  }
}