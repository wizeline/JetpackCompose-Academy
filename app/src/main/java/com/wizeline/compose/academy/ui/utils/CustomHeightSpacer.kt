package com.wizeline.compose.academy.ui.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomHeightSpacer(spacerHeight: SpacerHeight = SpacerHeight.MEDIUM) {
    return Spacer(modifier = Modifier.height(spacerHeight.height))
}

enum class SpacerHeight(val height: Dp) {
    EXTRA_SMALL(5.dp),
    SMALL(10.dp),
    MEDIUM(15.dp),
    LARGE(20.dp),
    EXTRA_LARGE(25.dp)
}