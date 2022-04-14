package com.wizeline.compose.academy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.dummy.hotelList
import com.wizeline.compose.academy.data.model.Place
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun DetailCardContent(place: Place, modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
        elevation = 0.dp, modifier = modifier
    ) {
        LazyColumn {
            item {
                Column(modifier = Modifier.padding(10.dp)) {
                    CustomPlaceName(name = place.name)
                    CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)
                    CustomRanking(ranking = place.ranking, reviews = place.review, true)
                    CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)
                    CustomPlaceLocation(
                        location = place.location,
                        iconTint = MaterialTheme.colors.primary
                    )
                    CustomHeightSpacer()

                    HorizontalTabList(list = listOf("Overview", "Details", "Costs"))
                    CustomHeightSpacer()
                    Text(
                        text = stringResource(R.string.label_place_description),
                        style = MaterialTheme.typography.body1
                    )
                    CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = stringResource(id = R.string.label_see_more),
                            style = MaterialTheme.typography.body1.copy(
                                color = MaterialTheme.colors.primary
                            )
                        )
                        Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = "ForwardIcon",
                            tint = MaterialTheme.colors.primary
                        )
                    }

                    CustomHeightSpacer()

                    LazyRow() {
                        items(
                            listOf(
                                R.drawable.hotel_gallery,
                                R.drawable.hotel_gallery_2,
                                R.drawable.hotel_gallery_3
                            )
                        ) {
                            Image(
                                painter = painterResource(id = it),
                                contentDescription = "Hotel image",
                                modifier = Modifier
                                    .size(150.dp)
                                    .clip(MaterialTheme.shapes.medium),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }

                    CustomHeightSpacer()

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CustomPlacePrice(price = place.price)
                        CustomButton(
                            modifier = Modifier.wrapContentWidth(),
                            label = stringResource(id = R.string.label_check_availability)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewDetailCardScreen() {
    ComposeAcademyTheme {
        Surface {
            DetailCardContent(hotelList[0], modifier = Modifier.fillMaxWidth())
        }
    }
}