package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomHeightSpacer(
    height: SpacerSize = SpacerSize.MEDIUM
) {
    Spacer(modifier = Modifier.height(getSpaceDp(height)))
}

@Composable
fun CustomWidthSpacer(
    witdh: SpacerSize = SpacerSize.MEDIUM
) {
    Spacer(modifier = Modifier.width(getSpaceDp(witdh)))
}

private fun getSpaceDp(space: SpacerSize) : Dp {
    return when (space) {
        SpacerSize.EXTRA_SMALL -> 5.dp
        SpacerSize.SMALL -> 10.dp
        SpacerSize.MEDIUM -> 15.dp
        SpacerSize.LARGE -> 20.dp
        SpacerSize.EXTRA_LARGE -> 25.dp
    }
}

enum class SpacerSize {
    EXTRA_SMALL,SMALL,MEDIUM, LARGE, EXTRA_LARGE
}

