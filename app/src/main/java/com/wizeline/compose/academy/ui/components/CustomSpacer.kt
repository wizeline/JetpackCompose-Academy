package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomHeightSpacer(
    spacerHeight: SpacerHeight = SpacerHeight.MEDIUM
) {
    val height = when(spacerHeight){
        SpacerHeight.EXTRA_SMALL -> 5.dp
        SpacerHeight.SMALL -> 10.dp
        SpacerHeight.MEDIUM -> 15.dp
        SpacerHeight.LARGE -> 20.dp
        SpacerHeight.EXTRA_LARGE -> 25.dp
    }
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun CustomWidthSpacer(
    spacerWidth: SpacerWidth = SpacerWidth.MEDIUM
) {
    val width = when(spacerWidth){
        SpacerWidth.EXTRA_SMALL -> 5.dp
        SpacerWidth.SMALL -> 10.dp
        SpacerWidth.MEDIUM -> 15.dp
        SpacerWidth.LARGE -> 20.dp
        SpacerWidth.EXTRA_LARGE -> 25.dp
    }
    Spacer(modifier = Modifier.width(width))
}

enum class SpacerHeight {
    EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
}

enum class SpacerWidth {
    EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
}