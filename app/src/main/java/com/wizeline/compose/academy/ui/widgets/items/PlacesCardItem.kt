package com.wizeline.compose.academy.ui.widgets.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.models.PlaceItem
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.widgets.buttons.CircleIconButton
import com.wizeline.compose.academy.ui.widgets.custom.CustomSpacer
import com.wizeline.compose.academy.ui.widgets.custom.SpacerSize.EXTRA_SMALL
import com.wizeline.compose.academy.ui.widgets.ratingbars.StarsRating
import com.wizeline.compose.academy.ui.widgets.textfields.AddressLabel
import com.wizeline.compose.academy.ui.widgets.textfields.CardTitle
import com.wizeline.compose.academy.ui.widgets.textfields.PriceText

@Composable
fun PlacesCardItem(item: PlaceItem = PlaceItem()) {
  Card(
    modifier = Modifier.padding(5.dp),
    shape = MaterialTheme.shapes.medium,
    elevation = 5.dp
  ) {

    Column {

      Box(
        contentAlignment = Alignment.TopEnd
      ) {
        Image(
          painter = painterResource(id = item.image),
          contentDescription = "Card for places",
          contentScale = ContentScale.Crop,
          modifier = Modifier
            .height(200.dp)
            .width(250.dp)
            .padding(5.dp)
            .clip(MaterialTheme.shapes.medium)
        )
        CircleIconButton()
      }

      Column(
        modifier = Modifier.padding(
          horizontal = 15.dp,
          vertical = 8.dp
        )
      ) {

        CustomSpacer(EXTRA_SMALL)

        StarsRating(item.rating, item.reviews)

        CustomSpacer(EXTRA_SMALL)

        CardTitle(title = item.name)

        CustomSpacer(EXTRA_SMALL)

        AddressLabel(address = item.address)

        CustomSpacer(EXTRA_SMALL)

        PriceText(item.price)
      }
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewPlacesCardItem() {
  ComposeAcademyTheme {
    Surface {
      PlacesCardItem()
    }
  }
}