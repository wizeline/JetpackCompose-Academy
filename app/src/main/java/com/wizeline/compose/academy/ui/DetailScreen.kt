package com.wizeline.compose.academy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.data.dummy.hotelList
import com.wizeline.compose.academy.data.model.Place
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun DetailScreen(place: Place) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(.5F), contentAlignment = Alignment.TopCenter) {
                Image(
                    painter = painterResource(id = place.imageResourceId),
                    contentDescription = "Place image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

                CustomHeightSpacer()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleIconButton(icon = Icons.Default.ArrowBack)
                    CircleIconButton(icon = Icons.Default.FavoriteBorder)
                }

            }
        }

        DetailCardContent(place = place, modifier = Modifier.fillMaxWidth().fillMaxHeight(0.7F))
    }

}

@Composable
@Preview
fun PreviewDetailScreen() {
    ComposeAcademyTheme {
        Surface {
            DetailScreen(hotelList[0])
        }
    }
}