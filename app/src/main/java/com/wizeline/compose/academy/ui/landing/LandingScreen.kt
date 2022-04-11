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
import com.wizeline.compose.academy.LocalNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.components.common.CustomButton
import com.wizeline.compose.academy.ui.components.common.CustomSpacer
import com.wizeline.compose.academy.ui.extensions.defaultScreen
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun LandingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LandingImage()
        LandingContent()
    }
}

@Composable
private fun LandingImage(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.landing_2),
        contentDescription = "landing_image",
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
private fun LandingContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.defaultScreen(),
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
            style = MaterialTheme.typography.body1.copy(
                color = Color.White,
            )
        )

        CustomSpacer()

        val navcontroller = LocalNavController.current

        CustomButton(
            title = stringResource(id = R.string.label_sign_in),
            modifier = Modifier.fillMaxWidth()
        ) {
            navcontroller.navigate("home")
        }

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


@Composable
@Preview
fun PreviewLandingScreen() {
    ComposeAcademyTheme {
        Surface {
            LandingScreen()
        }
    }
}
