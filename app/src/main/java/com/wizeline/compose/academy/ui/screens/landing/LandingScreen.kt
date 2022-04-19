package com.wizeline.compose.academy.ui.screens.landing

import android.content.res.Configuration
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
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.tools.dp_20
import com.wizeline.compose.academy.ui.components.others.CustomHeightSpacer
import com.wizeline.compose.academy.ui.components.buttons.CustomButton
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

/**
 * This composable represent the landing screen of the app.
 * I like to put comas at the end because if you need to move a line,
 * with the coma is easier to do that change and you don't need to add new commas
 */
@Composable
fun LandingScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.landing),
            contentDescription = stringResource(id = R.string.landingDescription),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dp_20),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = stringResource(id = R.string.label_explore_places),
                style = MaterialTheme.typography.h4.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                ),
            )

            CustomHeightSpacer()

            Text(
                text = stringResource(id = R.string.label_explore_places_description),
                style = MaterialTheme.typography.body1.copy(
                    color = Color.White,
                ),
            )

            CustomHeightSpacer()

            CustomButton(
                stringResource(id = R.string.label_sign_in),
                modifier = Modifier.fillMaxWidth()
            )

            CustomHeightSpacer()

            Text(
                text = stringResource(id = R.string.label_create_account),
                color = Color.White,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview
@Composable
private fun LandingScreenPreview() {
    ComposeAcademyTheme {
        Surface {
            LandingScreen()
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LandingScreenDarkPreview() {
    LandingScreenPreview()
}
