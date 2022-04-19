package com.wizeline.compose.academy.ui.components.texts

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.tools.sp_16
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.extendedColors

@Composable
fun PlaceItemPrice(
    price: String,
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = sp_16,
                ),
            ) {
                append(price)
            }
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.extendedColors.PrimaryGray
                )
            ) {
                append(stringResource(id = R.string.perNight))
            }
        },
    )
}

@Preview
@Composable
private fun PlaceItemPricePreview() {
    ComposeAcademyTheme {
        Surface {
            PlaceItemPrice("$1,260")
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PlaceItemPriceDarkPreview() {
    PlaceItemPricePreview()
}
