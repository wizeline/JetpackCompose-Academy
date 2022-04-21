package com.wizeline.compose.academy.ui.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.wizeline.compose.academy.ui.theme.Dimens

@Composable
fun LandingPage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        LandingImage()
        PageBody()
    }
}

@Composable
private fun LandingImage() {
    Image(
        painter = painterResource(id = R.drawable.landing),
        contentDescription = "landing_image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun PageBody() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.padding(horizontal = 32.dp, vertical = Dimens.ITEM_SEPARATION_NORMAL.size)
    ) {
        Text(
            text = stringResource(id = R.string.label_explore_places),
            style = MaterialTheme.typography.h4.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = stringResource(id = R.string.label_explore_places_description),
            style = MaterialTheme.typography.body1.copy(
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
        ){
            Text(
                text = stringResource(id = R.string.label_sign_in),
                modifier = Modifier.padding(vertical = Dimens.ITEM_SEPARATION_SMALL.size),
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.SemiBold
            )
        }
        Text(
            text = stringResource(id = R.string.label_create_account),
            style = MaterialTheme.typography.body1.copy(
                textDecoration = TextDecoration.Underline,
                color = Color.White,
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
        )
    }
}

@Preview
@Composable
fun PreviewLandingPage() {
    ComposeAcademyTheme {
        Surface {
            LandingPage()
        }
    }
}