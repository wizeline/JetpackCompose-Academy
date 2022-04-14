package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.gold

@Composable
fun Rating(stars: Int = 3, reviews: Int = 200) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until stars) {
            Icon(
                Icons.Default.Star,
                contentDescription = stringResource(id = R.string.label_icon),
                tint = gold
            )
        }
        for (i in stars..4) {
            Icon(
                Icons.Default.Star,
                contentDescription = stringResource(id = R.string.label_icon),
                tint = Color.Gray
            )
        }
        CustomWidthSpacer(SpacerSize.SMALL)
        Text(
            text = stringResource(id = R.string.review_format, reviews),
            style = MaterialTheme.typography.body2.copy(
                color = Color.Gray,
                fontWeight = FontWeight.Light
            )
        )
    }
}


@Composable
@Preview
fun PreviewRating() {
    ComposeAcademyTheme {
        Surface {
            Rating()
        }
    }
}