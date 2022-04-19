package com.wizeline.compose.academy.ui.components.texts

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.tools.dp_200
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.extendedColors

@Composable
fun PlaceItemAddress(
    address: String,
    tintColor: Color = MaterialTheme.extendedColors.PrimaryGravyVariant
) {
    Row {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = stringResource(id = R.string.locationDescription),
            tint = tintColor,
        )
        Text(
            text = address,
            style = MaterialTheme.typography.body1.copy(
                color = tintColor,
            ),
            modifier = Modifier.width(dp_200),
        )
    }
}

@Preview
@Composable
private fun PlaceItemAddressPreview() {
    ComposeAcademyTheme {
        Surface {
            PlaceItemAddress(address = "Av perico, Mexicali")
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PlaceItemAddressDarkPreview() {
    PlaceItemAddressPreview()
}
