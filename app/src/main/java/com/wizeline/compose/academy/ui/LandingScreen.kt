package com.wizeline.compose.academy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun LandingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.landing_2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
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
            CustomHeightSpacer()

            Text(
                text = stringResource(id = R.string.label_explore_places_description),
                style = MaterialTheme.typography.body1.copy(
                    color = Color.White
                )
            )

            CustomHeightSpacer()

            CustomButton(
                title = stringResource(id = R.string.label_sign_in),
                modifier = Modifier.fillMaxWidth()
            )
            CustomHeightSpacer()

            Text(
                text = stringResource(id = R.string.label_create_account),
                color = Color.White,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun CustomButton(
    title: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}
@Composable
fun CustomHeightSpacer(
    height: SpacerHeight = SpacerHeight.MEDIUM
) {
    val size = when (height) {
        SpacerHeight.EXTRA_SMALL -> 5.dp
        SpacerHeight.SMALL -> 10.dp
        SpacerHeight.MEDIUM -> 15.dp
        SpacerHeight.LARGE -> 20.dp
        SpacerHeight.EXTRA_LARGE -> 25.dp
    }
    Spacer(modifier = Modifier.height(size))
}

enum class SpacerHeight {
    EXTRA_SMALL,SMALL,MEDIUM, LARGE, EXTRA_LARGE
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
