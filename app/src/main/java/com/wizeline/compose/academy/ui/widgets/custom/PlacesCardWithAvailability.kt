package com.wizeline.compose.academy.ui.widgets.custom

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R.string
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant
import com.wizeline.compose.academy.ui.widgets.buttons.CustomButton
import com.wizeline.compose.academy.ui.widgets.carousels.PlacesCarousel
import com.wizeline.compose.academy.ui.widgets.ratingbars.StarsRating
import com.wizeline.compose.academy.ui.widgets.textfields.AddressLabel
import com.wizeline.compose.academy.ui.widgets.textfields.CardTitle
import com.wizeline.compose.academy.ui.widgets.textfields.PriceText

@Composable
fun PlacesCardWithAvailability(
  modifier: Modifier = Modifier
) {
  Card(
    shape = RoundedCornerShape(
      topEnd = 20.dp,
      topStart = 20.dp
    ),
    elevation = 0.dp,
    modifier = modifier
  ) {

    Column(
      modifier = Modifier
        .padding(12.dp)
        .verticalScroll(ScrollState(0))
    ) {

      CardTitle(
        title = stringResource(id = string.label_places_card_one),
        style = MaterialTheme.typography.h5
      )

      CustomSpacer()

      StarsRating(showLabel = true, reviews = 347)

      CustomSpacer()

      AddressLabel(
        address = "Av. Damero, 77310 Isla Holbox, Q.R., México",
        iconTintColor = MaterialTheme.colors.primary
      )

      CustomSpacer()

      TabLayout(
        items = listOf("Overview", "Details", "Costs"),
        selectedItem = 0
      )

      CustomSpacer()

      Text(
        text = stringResource(id = string.label_place_description),
        color = PrimaryGravyVariant
      )

      Row {
        Text(
          text = "See more",
          color = MaterialTheme.colors.primary
        )
        Icon(
          imageVector = Icons.Default.ArrowForward,
          contentDescription = "Forward Icon",
          tint = MaterialTheme.colors.primary
        )
      }

      CustomSpacer()

      PlacesCarousel()

      CustomSpacer()

      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
      ) {
        PriceText()
        CustomButton(resId = string.label_check_availability)
      }
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewPlacesCardWithAvailability() {
  ComposeAcademyTheme {
    androidx.compose.material.Surface {
      PlacesCardWithAvailability()
    }
  }
}