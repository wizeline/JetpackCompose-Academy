package com.wizeline.compose.academy.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant
import com.wizeline.compose.academy.ui.theme.PrimaryGray
import com.wizeline.compose.academy.ui.theme.PrimaryOrange
import com.wizeline.compose.academy.ui.utils.CircleFavorite

@Composable
fun PlacementItemView() {
    Card {
        Column(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)
        ) {
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_image),
                    contentDescription = "place",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

                CircleFavorite(icon = Icons.Default.FavoriteBorder)
            }


            Column {
                Ranking()

                HotelName(hotelName = "Casa de las tortugas")

                HotelAddress(address = "Av. Romero, México")

                TextPriceByNight()
            }
        }
    }
}

@Composable
fun Ranking(
    numberVotes: Int = 0,
    showLabel: Boolean = false
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        for (i in 1..5) {
            Icon(
                Icons.Default.Star,
                contentDescription = "star",
                tint = PrimaryOrange
            )
        }

        Text(
            text = if (showLabel) stringResource(
                R.string.label_ranking_quantity_review,
                numberVotes.toString()
            )
            else stringResource(R.string.label_ranking_quantity, numberVotes.toString()),
            style = MaterialTheme.typography.body2.copy(
                color = PrimaryGravyVariant
            )
        )
    }
}

@Composable
fun TextPriceByNight() {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            ) {
                append("$1,234")
            }

            withStyle(
                style = SpanStyle(
                    color = PrimaryGray
                )
            ) {
                append("/")
                append("night")
            }
        }
    )
}

@Composable
fun HotelAddress(
    address: String,
    tint: Color = PrimaryGravyVariant
) {
    Row {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = "location"
        )

        Text(
            text = address,
            style = MaterialTheme.typography.body1.copy(
                color = tint
            )
        )
    }
}

@Composable
fun HotelName(
    hotelName: String,
    style: TextStyle = MaterialTheme.typography.h6
) {
    Text(
        text = hotelName,
        style = style.copy(
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
@Preview
fun PlacementItemViewPreview() {
    ComposeAcademyTheme {
        Surface {
            PlacementItemView()
        }
    }
}