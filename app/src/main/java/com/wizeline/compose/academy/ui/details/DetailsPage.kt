package com.wizeline.compose.academy.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.getFormatMoney
import com.wizeline.compose.academy.domain.models.PlaceModel
import com.wizeline.compose.academy.ui.common.CircularButton
import com.wizeline.compose.academy.ui.common.StarRateView
import com.wizeline.compose.academy.ui.home.TabsMenu
import com.wizeline.compose.academy.ui.theme.Dimens

val tab_options = arrayOf("Overview", "Details", "Costs")
val demo_images = arrayOf(
    R.drawable.hotel_gallery,
    R.drawable.hotel_gallery_2,
    R.drawable.hotel_gallery_3
)

@Composable
fun DetailsPage(place: PlaceModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        DetailsHeader(
            Modifier
                .align(Alignment.TopStart)
                .fillMaxHeight(0.5f)
        )
        DetailsCard(
            Modifier
                .align(Alignment.BottomStart)
                .fillMaxHeight(0.55f),place)
    }
}

@Composable
fun DetailsHeader(modifier: Modifier) {
    Box(
        modifier
    ){
        Image(
            painter = painterResource(id = R.drawable.hotel_image_1),
            contentDescription = "image details",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            CircularButton(icon = Icons.Default.ArrowBack) {}
            CircularButton(icon = Icons.Default.FavoriteBorder) {}
        }
    }
}

@Composable
fun DetailsCard(modifier: Modifier, place: PlaceModel) {
    Box(
        modifier
    ) {
        Card(
            shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
            elevation = 0.dp,
            modifier = Modifier
                .fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background
        ) {
            LazyColumn(
                modifier = Modifier.padding(Dimens.ITEM_SEPARATION_NORMAL.size)
            ) {
                item {
                    Text(
                        text = place.title,
                        style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    StarRateView(place = place, true)
                    Row(
                        modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
                    ) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = "location icon",
                            tint = MaterialTheme.colors.primary
                        )
                        Text(
                            text =  place.address,
                            style = MaterialTheme.typography.body1.copy(
                                color = Color.DarkGray
                            )
                        )
                    }
                    TabsMenu(tab_options)
                    Text(
                        text = stringResource(id = R.string.label_place_description),
                        style = MaterialTheme.typography.body2.copy(
                            color = Color.DarkGray
                        ),
                        modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
                    )

                    Text(
                        text = stringResource(id = R.string.label_see_more),
                        style = MaterialTheme.typography.body2.copy(
                            color = MaterialTheme.colors.primary
                        ),
                        modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
                    )

                    LazyRow {
                        for (resource in demo_images) {
                            item {
                                Image(
                                    painter = painterResource(id = resource),
                                    contentDescription = "gallery image",
                                    modifier = Modifier
                                        .padding(Dimens.ITEM_SEPARATION_NORMAL.size)
                                        .clip(RoundedCornerShape(20.dp))
                                        .size(120.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = MaterialTheme.colors.primary,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = MaterialTheme.typography.h5.fontSize
                                    )
                                ) {
                                    append(place.price)
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.LightGray,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = MaterialTheme.typography.h6.fontSize
                                    )
                                ) {
                                    append("/${place.priceRate}")
                                }
                            },
                            modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_SMALL.size)
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
                        ){
                            Text(
                                text = stringResource(id = R.string.label_check_availability),
                                modifier = Modifier.padding(vertical = Dimens.ITEM_SEPARATION_SMALL.size),
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun previewDetailsPage() {
    MaterialTheme {
        Surface {
            DetailsPage(PlaceModel("Test","address",100.00.getFormatMoney(),"night",234,4.3))
        }
    }
}