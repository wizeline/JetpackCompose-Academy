package com.wizeline.compose.academy.ui.components.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.extensions.getGrayVariantColor
import com.wizeline.compose.academy.ui.theme.*

@Composable
fun StarRanking(
    reviews: String = "",
    numOfStars: Int = 5,
    showLabel: Boolean = false,
    starRankingSize: StarRankingSize = StarRankingSize.NORMAL
) {
    val iconSize = when(starRankingSize) {
        StarRankingSize.SMALL -> dimen_15dp
        StarRankingSize.NORMAL -> dimen_20dp
    }

    val textStyle = when(starRankingSize) {
        StarRankingSize.SMALL -> MaterialTheme.typography.overline
        StarRankingSize.NORMAL -> MaterialTheme.typography.body2
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until numOfStars) {
            Icon(
                Icons.Default.Star,
                contentDescription = "ranking",
                tint = PrimaryOrange,
                modifier = Modifier.size(iconSize)
            )
        }
        Text(
            text = if (showLabel) "($reviews) reviews" else "($reviews)",
            style = textStyle.copy(
                color = getGrayVariantColor()
            )
        )
    }
}

enum class StarRankingSize {
    SMALL,NORMAL
}

@Composable
@Preview(name = "light_mode")
@Preview(name = "dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewStarRanking() {
    ComposeAcademyTheme {
        Surface {
            Column {
                StarRanking(
                    reviews = "534",
                    numOfStars = 2
                )
                StarRanking(
                    reviews = "234",
                    numOfStars =5 ,
                    starRankingSize = StarRankingSize.SMALL,
                    showLabel = true
                )
            }
        }
    }
}
