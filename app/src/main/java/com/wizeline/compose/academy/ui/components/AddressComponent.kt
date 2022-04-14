package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryBlue

@Composable
fun AddressComponent(isOn: Boolean = false){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = null,
            tint =if(isOn) PrimaryBlue else Color.Gray
        )
        CustomWidthSpacer(SpacerSize.SMALL)
        Text(
            text = stringResource(id = R.string.addres_sample_2),
            style = MaterialTheme.typography.body1
        )
    }

}

@Composable
@Preview
fun PreviewAddressComponent(){
    ComposeAcademyTheme {
        Surface {
            AddressComponent()
        }
    }
}