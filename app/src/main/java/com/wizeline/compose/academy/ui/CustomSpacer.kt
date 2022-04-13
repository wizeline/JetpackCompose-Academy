package com.wizeline.compose.academy.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomHeightSpacer(spacerHeight: SpacerHeight = SpacerHeight.MEDIUM) {
    val height = when (spacerHeight) {
        SpacerHeight.EXTRA_SMALL -> 5.dp
        SpacerHeight.SMALL -> 10.dp
        SpacerHeight.MEDIUM -> 15.dp
        SpacerHeight.LARGE -> 20.dp
        SpacerHeight.EXTRA_LARGE -> 25.dp
    }
    Spacer(modifier = Modifier.height(height))
}

enum class SpacerHeight {
    EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
}