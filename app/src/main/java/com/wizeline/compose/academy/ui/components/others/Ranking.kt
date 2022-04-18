package com.wizeline.compose.academy.ui.components.others

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryOrange
import com.wizeline.compose.academy.ui.theme.extendedColors

@Composable
fun Ranking(
    rankingValue: Int,
    showLabel: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        for (i in 1..5) {
            Icon(
                Icons.Default.Star,
                contentDescription = stringResource(id = R.string.rankingDescription),
                tint = PrimaryOrange,
            )
        }

        Text(
            text = if (showLabel) stringResource(
                id = R.string.txtReviews,
                rankingValue
            ) else stringResource(
                id = R.string.txtRanking,
                rankingValue
            ),
            style = MaterialTheme.typography.body2.copy(
                color = MaterialTheme.extendedColors.PrimaryGravyVariant
            )
        )
    }
}

@Preview
@Composable
private fun RankingPreview() {
    ComposeAcademyTheme {
        Surface {
            Ranking(198)
        }
    }
}

@Preview
@Composable
private fun RankingReviewsPreview() {
    ComposeAcademyTheme {
        Surface {
            Ranking(100, true)
        }
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun RankingDarkPreview() {
    RankingPreview()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun RankingReviewsDarkPreview() {
    RankingReviewsPreview()
}
