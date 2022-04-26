package com.wizeline.compose.academy.ui.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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
import com.wizeline.compose.academy.ui.components.CustomButton
import com.wizeline.compose.academy.ui.components.CustomHeightSpacer
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun LandingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.landing),
            contentDescription = "landing_image",
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

            CustomHeightSpacer()

            Text(
                text = stringResource(id = R.string.label_explore_places_description),
                style = MaterialTheme.typography.body1.copy(
                    color = Color.White
                )
            )

            CustomHeightSpacer()

            CustomButton(stringResource(id = R.string.label_sign_in), modifier = Modifier.fillMaxWidth())

            CustomHeightSpacer()

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

@Preview(showBackground = true)
@Composable
fun PreviewLandingScreen() {
    ComposeAcademyTheme {
        Surface{
            LandingScreen()
        }
    }
}