package com.wizeline.compose.academy.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.Dimens

@Composable
fun DestinyItem(place: PlaceModel) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(Dimens.ITEM_SEPARATION_NORMAL.size),
    ) {
        Column(
            modifier = Modifier.padding(Dimens.ITEM_SEPARATION_NORMAL.size)
        ) {
            Box(
                contentAlignment = Alignment.TopEnd,
            ) {
                Image(
                    painterResource(id = R.drawable.hotel_image_1),
                    contentDescription = "destiny image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                CircularButton(Icons.Default.FavoriteBorder) {}
            }
            StarRateView(place)
            Text(
                text =  place.title,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_SMALL.size)
            )
            Row(
                modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_SMALL.size)
            ) {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = "location icon",
                    tint = Color.LightGray
                )
                Text(
                    text =  place.address,
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.LightGray
                    )
                )
            }
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
        }
    }
}

@Preview
@Composable
fun DestinyItemPreview() {
    ComposeAcademyTheme {
        Surface {
            DestinyItem(
                PlaceModel("Test","address",100.00.getFormatMoney(),"night",234,4.3)
            )
        }
    }
}