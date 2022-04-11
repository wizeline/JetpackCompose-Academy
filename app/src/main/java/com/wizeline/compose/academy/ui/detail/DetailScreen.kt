package com.wizeline.compose.academy.ui.detail

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.models.Place
import com.wizeline.compose.academy.domain.DataGenerator
import com.wizeline.compose.academy.ui.components.common.*
import com.wizeline.compose.academy.ui.components.place.*
import com.wizeline.compose.academy.ui.extensions.getGrayVariantColor
import com.wizeline.compose.academy.ui.theme.*

@Composable
fun DetailScreen(
    place: Place = DataGenerator.getPlace
) {
    val size = LocalConfiguration.current
    val headerHeight = size.screenHeightDp * 0.3
    val contentHeight = size.screenHeightDp * 0.73

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        DetailImageHeader(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight.dp),
            painter = painterResource(id = place.image)
        )

        DetailCardContent(
            modifier = Modifier
                .fillMaxWidth()
                .height(contentHeight.dp),
            place = place
        )
    }
}

@Composable
private fun DetailImageHeader(
    modifier: Modifier = Modifier,
    painter: Painter
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painter,
                contentDescription = "header_image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CircleIconButton(
                    icon = Icons.Default.ArrowBack
                ) {}
                CircleIconButton(
                    icon = Icons.Default.FavoriteBorder
                ){}
            }
        }
    }
}


@Composable
private fun DetailCardContent(
    modifier: Modifier = Modifier,
    place: Place
) {
    Card(
        shape = RoundedCornerShape(
            topEnd = dimen_30dp,
            topStart = dimen_30dp
        ),
        elevation = dimen_0dp,
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.padding(dimen_10dp)
        ) {

            item {
                CustomSpacer()
                PlaceItemName(
                    name = place.name,
                    style = MaterialTheme.typography.h5
                )
                CustomSpacer()
                StarRanking(
                    showLabel = true,
                    numOfStars = place.ranking,
                    reviews = place.reviews.toString()
                )
                CustomSpacer()
                PlaceItemAddress(
                    address = place.address
                )
                CustomSpacer()
                HorizontalTabList(
                    list = listOf(
                        stringResource(id = R.string.label_overview),
                        stringResource(id = R.string.label_details),
                        stringResource(id = R.string.label_costs)
                    )
                )
                CustomSpacer()
                Text(
                    text = stringResource(id = R.string.label_explore_places_description),
                    color = getGrayVariantColor()
                )
                CustomSpacer()
                Row {
                    Text(
                        text = stringResource(id = R.string.label_see_more),
                        color = MaterialTheme.colors.primary
                    )
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "icon",
                        tint = MaterialTheme.colors.primary
                    )
                }
                CustomSpacer()
                PlaceImageGallery()

                CustomSpacer()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    PlaceItemPrice(place.price.toString())
                    CustomButton(
                        title = stringResource(id = R.string.label_check_availability)
                    ) {}
                }
            }

        }
    }
}


@Composable
@Preview(name = "light_mode")
@Preview(name = "dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewDetailScreen() {
    ComposeAcademyTheme {
        Surface {
            DetailScreen()
        }
    }
}
