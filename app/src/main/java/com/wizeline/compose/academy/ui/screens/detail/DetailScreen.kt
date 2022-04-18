package com.wizeline.compose.academy.ui.screens.detail

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.models.GalleryImage
import com.wizeline.compose.academy.models.Place
import com.wizeline.compose.academy.models.Section
import com.wizeline.compose.academy.tools.dp_0
import com.wizeline.compose.academy.tools.dp_10
import com.wizeline.compose.academy.tools.dp_30
import com.wizeline.compose.academy.ui.components.buttons.CircleIconButton
import com.wizeline.compose.academy.ui.components.buttons.CustomButton
import com.wizeline.compose.academy.ui.components.images.PlaceImageGallery
import com.wizeline.compose.academy.ui.components.others.CustomHeightSpacer
import com.wizeline.compose.academy.ui.components.others.Ranking
import com.wizeline.compose.academy.ui.components.tabs.HorizontalTabList
import com.wizeline.compose.academy.ui.components.texts.PlaceItemAddress
import com.wizeline.compose.academy.ui.components.texts.PlaceItemPrice
import com.wizeline.compose.academy.ui.components.texts.PlaceItemTitle
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.extendedColors

@Composable
fun DetailScreen(
    place: Place,
    placeHolder: Int = R.drawable.placeholder,
    click: (() -> Unit)? = null,
) {

    val size = LocalConfiguration.current
    val height = size.screenHeightDp * 0.3
    val contentHeight = size.screenHeightDp * 0.73

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = place.imageUrl,
                        builder = {
                            placeholder(placeHolder)
                        }),
                    contentDescription = stringResource(id = R.string.headerDescription),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth(),
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    CircleIconButton(icon = Icons.Default.ArrowBack)

                    CircleIconButton(icon = Icons.Default.FavoriteBorder)
                }
            }
        }

        DetailCardContent(
            place,
            placeHolder,
            modifier = Modifier
                .fillMaxWidth()
                .height(contentHeight.dp),
            click
        )
    }
}

@Composable
fun DetailCardContent(
    place: Place,
    placeHolder: Int,
    modifier: Modifier = Modifier,
    click: (() -> Unit)? = null,
) {
    Card(
        shape = RoundedCornerShape(
            topEnd = dp_30,
            topStart = dp_30,
        ),
        elevation = dp_0,
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.padding(dp_10)
        ) {

            item {
                CustomHeightSpacer()
                PlaceItemTitle(
                    name = place.name,
                    style = MaterialTheme.typography.h5,
                )

                CustomHeightSpacer()
                Ranking(place.rank, showLabel = true)

                CustomHeightSpacer()
                PlaceItemAddress(address = place.address)

                CustomHeightSpacer()
                HorizontalTabList(list = place.information)

                CustomHeightSpacer()
                Text(
                    text = stringResource(id = R.string.label_place_description),
                    color = MaterialTheme.extendedColors.PrimaryGravyVariant,
                )

                CustomHeightSpacer()
                Row {
                    Text(
                        text = stringResource(id = R.string.txtSeeMore),
                        color = MaterialTheme.colors.primary
                    )

                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = stringResource(id = R.string.iconDescription),
                        tint = MaterialTheme.colors.primary
                    )
                }

                CustomHeightSpacer()
                PlaceImageGallery(place.images, placeHolder)

                CustomHeightSpacer()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    PlaceItemPrice(place.price)
                    CustomButton(stringResource(id = R.string.txtAvailability), click = click)
                }
            }
        }
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    ComposeAcademyTheme {
        Surface {
            DetailScreen(
                Place(
                    1,
                    "Casa de las Tortugas",
                    "Av quack, Mexicali",
                    "",
                    34,
                    "$333.00",
                    listOf(
                        Section(1, "Overview"),
                        Section(2, "Details"),
                        Section(3, "Costs")
                    ),
                    listOf(
                        GalleryImage(
                            1,
                            ""
                        ),
                        GalleryImage(
                            2,
                            ""
                        ),
                        GalleryImage(
                            3,
                            ""
                        ),
                        GalleryImage(
                            4,
                            ""
                        ),
                    )
                ),
                R.drawable.hotel_image_2
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun DetailScreenDarkPreview() {
    DetailScreenPreview()
}
