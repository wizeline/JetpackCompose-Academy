package com.wizeline.compose.academy.ui.components.place

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.data.models.Place
import com.wizeline.compose.academy.domain.DataGenerator
import com.wizeline.compose.academy.ui.components.common.*
import com.wizeline.compose.academy.ui.extensions.getGrayVariantColor
import com.wizeline.compose.academy.ui.theme.*

@Composable
fun PlaceItemCard(
   place: Place
) {
    Card(
        modifier = Modifier.padding(dimen_5dp)
            .clickable {  },
        shape = MaterialTheme.shapes.medium,
        elevation = dimen_5dp
    ) {
       Column {

           PlaceItemImage(
               image = painterResource(id = place.image)
           )

           Column(
               modifier = Modifier.padding(horizontal = dimen_15dp, vertical = dimen_5dp)
           ) {

               CustomSpacer(
                   spacerDimens = SpacerDimens.EXTRA_SMALL
               )

               StarRanking(
                   reviews = place.reviews.toString(),
                   starRankingSize = StarRankingSize.SMALL,
                   numOfStars = place.ranking
               )

               CustomSpacer(
                   spacerDimens = SpacerDimens.EXTRA_SMALL
               )

               PlaceItemName(
                   name = place.name,
               )

               CustomSpacer(
                   spacerDimens = SpacerDimens.EXTRA_SMALL
               )

               PlaceItemAddress(
                   address = place.location
               )

               CustomSpacer(
                   spacerDimens = SpacerDimens.EXTRA_SMALL
               )

               PlaceItemPrice(
                   price = place.price.toString()
               )
           }
       }
    }
}

@Composable
fun PlaceItemName(
    name: String,
    style: TextStyle = MaterialTheme.typography.h6
) {
    Text(
        text = name,
        style = style.copy(
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun PlaceItemAddress(
    address: String,
    tintColor: Color = getGrayVariantColor(),
) {
    Row {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = "location_on",
            tint = tintColor
        )
        Text(
            text = address,
            style = MaterialTheme.typography.body1.copy(
                color = getGrayVariantColor()
            )
        )
    }
}

@Composable
fun PlaceItemPrice(
    price: String
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            ) {
                append("$price")
            }
            withStyle(
                style = SpanStyle(
                    color = getGrayVariantColor()
                )
            ) {
                append("/")
                append("night")
            }
        }
    )
}

@Composable
fun PlaceItemImage(
    image: Painter
) {

    Box(
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = image,
            contentDescription = "place_image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimen_250dp)
                .padding(dimen_5dp)
                .clip(MaterialTheme.shapes.medium)
        )
        CircleIconButton(
            icon = Icons.Default.FavoriteBorder
        ) {}
    }
}


@Composable
@Preview(name = "light_mode")
@Preview(name ="dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewPlaceItemCard() {
    ComposeAcademyTheme {
        Surface {
            PlaceItemCard(
                DataGenerator.placeList[0]
            )
        }
    }
}
