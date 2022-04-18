package com.wizeline.compose.academy.ui.widgets.textfields

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGray

@Composable
fun PriceText(
  pricePerNight: Double = 1290.0
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
        append("$$pricePerNight")
      }
      withStyle(
        style = SpanStyle(
          color = PrimaryGray
        )
      ) {
        append("/night")
      }
    }
  )
}

@Composable
@Preview(showBackground = true)
fun PreviewPriceText() {
  ComposeAcademyTheme {
    Surface {
      PriceText()
    }
  }
}