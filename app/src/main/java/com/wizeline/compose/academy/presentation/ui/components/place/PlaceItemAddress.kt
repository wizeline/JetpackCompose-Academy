package com.wizeline.compose.academy.presentation.ui.components.place

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.presentation.ui.theme.PrimaryGravyVariant

@Composable
fun PlaceItemAddress(
    address: String,
    tintColor: Color = PrimaryGravyVariant){
    Row{
        Icon(
            Icons.Default.LocationOn,
            contentDescription = stringResource(id = R.string.label_location),
            tint = tintColor
        )
        Text(text = address,
            style= MaterialTheme.typography.body1.copy(
                color= PrimaryGravyVariant
            ))
    }
}

@Preview
@Composable
fun PreviewPlacetemAddress(){
    ComposeAcademyTheme {
        Surface{
            PlaceItemAddress(address = getPlaces()[0].location)
        }
    }
}