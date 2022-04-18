package com.wizeline.compose.academy.ui.components.texts

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun PlaceItemTitle(
    name: String,
    style: TextStyle = MaterialTheme.typography.h6
) {
    Text(
        text = name,
        style = style.copy(
            fontWeight = FontWeight.Bold,
        )
    )
}

@Preview
@Composable
private fun PlaceItemTitlePreview() {
    ComposeAcademyTheme {
        Surface {
            PlaceItemTitle(name = "Patios")
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PlaceItemTitleDarkPreview() {
    PlaceItemTitlePreview()
}
