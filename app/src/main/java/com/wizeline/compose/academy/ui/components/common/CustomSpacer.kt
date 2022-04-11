package com.wizeline.compose.academy.ui.components.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.*


@Composable
fun CustomSpacer(
    spacerDimens: SpacerDimens = SpacerDimens.MEDIUM,
    spacerOrientation: SpacerOrientation = SpacerOrientation.VERTICAL
) {
    val dimen = when (spacerDimens) {
        SpacerDimens.EXTRA_SMALL -> dimen_5dp
        SpacerDimens.SMALL -> dimen_10dp
        SpacerDimens.MEDIUM -> dimen_15dp
        SpacerDimens.LARGE -> dimen_20dp
        SpacerDimens.EXTRA_LARGE -> dimen_25dp
    }

    val modifier = when (spacerOrientation) {
        SpacerOrientation.VERTICAL -> Modifier.height(dimen)
        SpacerOrientation.HORIZONTAL -> Modifier.width(dimen)
    }

    Spacer(modifier = modifier)
}


enum class SpacerDimens {
    EXTRA_SMALL,SMALL,MEDIUM,LARGE,EXTRA_LARGE
}
enum class SpacerOrientation {
    VERTICAL, HORIZONTAL
}

