package com.wizeline.compose.academy.ui.components.cards

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.models.GalleryImage
import com.wizeline.compose.academy.models.Place
import com.wizeline.compose.academy.models.Section
import com.wizeline.compose.academy.tools.*
import com.wizeline.compose.academy.ui.components.buttons.CircleIconButton
import com.wizeline.compose.academy.ui.components.others.CustomHeightSpacer
import com.wizeline.compose.academy.ui.components.others.Ranking
import com.wizeline.compose.academy.ui.components.others.SpacerHeight
import com.wizeline.compose.academy.ui.components.texts.PlaceItemAddress
import com.wizeline.compose.academy.ui.components.texts.PlaceItemPrice
import com.wizeline.compose.academy.ui.components.texts.PlaceItemTitle
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun PlaceItemCard(
    place: Place,
    placeHolder: Int = R.drawable.placeholder
) {
    Card(
        modifier = Modifier.padding(dp_5),
        shape = MaterialTheme.shapes.medium,
        elevation = dp_5,
    ) {
        Column {
            Box(
                contentAlignment = Alignment.TopEnd,
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = place.imageUrl,
                        builder = {
                            placeholder(placeHolder)
                        }),
                    contentDescription = stringResource(id = R.string.placeDescription),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(dp_200)
                        .width(dp_250)
                        .padding(dp_5)
                        .clip(MaterialTheme.shapes.medium),
                )

                CircleIconButton(
                    icon = Icons.Default.FavoriteBorder,
                )
            }

            Column(
                modifier = Modifier.padding(
                    horizontal = dp_15,
                    vertical = dp_8,
                )
            ) {
                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                Ranking(place.rank)

                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                PlaceItemTitle(place.name)

                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                PlaceItemAddress(place.address)

                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                PlaceItemPrice(place.price)
            }
        }
    }
}

@Preview
@Composable
private fun PlaceItemCardPreview() {
    ComposeAcademyTheme {
        Surface {
            PlaceItemCard(
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
                R.drawable.hotel_image
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PlaceItemCardDarKPreview() {
    PlaceItemCardPreview()
}
