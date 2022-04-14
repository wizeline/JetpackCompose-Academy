package com.wizeline.compose.academy.ui.landing

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.components.CustomButton
import com.wizeline.compose.academy.ui.components.CustomHeightSpacer
import com.wizeline.compose.academy.ui.components.CustomImage
import com.wizeline.compose.academy.ui.components.SpacerSize
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun LandingScreen() {
    //Use Box
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        CustomImage(imageId = R.drawable.landing,
            description =
            stringResource(id = R.string.landing_description),
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
                style = MaterialTheme.typography.h3.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )
            CustomHeightSpacer(height = SpacerSize.MEDIUM)
            Text(
                text = stringResource(id = R.string.label_explore_places_description),
                style = MaterialTheme.typography.h5.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
            )
            CustomHeightSpacer(height = SpacerSize.MEDIUM)
            CustomButton(title = stringResource(id = R.string.label_sign_in),
                modifier = Modifier.fillMaxWidth(), onClick = {})
            CustomHeightSpacer(height = SpacerSize.MEDIUM)
            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = stringResource(id = R.string.label_create_account),
                style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color.White
                ),
            )
        }
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
