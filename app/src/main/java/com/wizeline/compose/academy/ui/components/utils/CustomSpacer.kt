package com.wizeline.compose.academy.ui.components.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomHeightSpacer(spacerSize: SpacerSize = SpacerSize.MEDIUM) {
    return Spacer(modifier = Modifier.height(spacerSize.size))
}

@Composable
fun CustomWidthSpacer(spacerSize: SpacerSize = SpacerSize.MEDIUM) {
    return Spacer(modifier = Modifier.width(spacerSize.size))
}

enum class SpacerSize(val size: Dp) {
    EXTRA_SMALL(5.dp),
    SMALL(10.dp),
    MEDIUM(15.dp),
    LARGE(20.dp),
    EXTRA_LARGE(25.dp)
}