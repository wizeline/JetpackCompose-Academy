package com.wizeline.compose.academy.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.domain.models.PlaceModel
import com.wizeline.compose.academy.ui.theme.Dimens
import com.wizeline.compose.academy.ui.theme.PrimaryOrange

@Composable
fun StarRateView(place: PlaceModel, shouldShowLabel: Boolean = false) {
    Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
    ) {
        for(star in 0 until place.rateAverage.toInt()) {
            Icon(
                Icons.Default.Star,
                contentDescription = "rating average icon",
                tint = PrimaryOrange,
                modifier = Modifier.size(if(shouldShowLabel) StarRankingSize.NORMAL.size else StarRankingSize.SMALL.size)
            )
        }
        Text(
            text = "(${place.rates} ${if(shouldShowLabel) "reviews" else ""})",
            style = MaterialTheme.typography.body2.copy(
                color = Color.LightGray
            )
        )
    }
}

enum class StarRankingSize(val size: Dp) {
    SMALL(15.dp),
    NORMAL(20.dp)
}