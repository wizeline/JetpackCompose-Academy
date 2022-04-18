package com.wizeline.compose.academy.ui.widgets.textfields

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant

@Composable
fun AddressLabel(
  address: String = "Av Damero, México",
  iconTintColor: Color = PrimaryGravyVariant
) {
  Row {
    Icon(
      imageVector = Icons.Default.LocationOn,
      contentDescription = "Address Icon",
      tint = iconTintColor
    )
    Text(
      text = address,
      style = MaterialTheme.typography.body1.copy(
        color = PrimaryGravyVariant
      )
    )
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewAddressLabel() {
  ComposeAcademyTheme {
    Surface {
      AddressLabel()
    }
  }
}