package com.wizeline.compose.academy.tools

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier

fun Modifier.defaultScreen() = this.apply {
    this
        .fillMaxSize()
        .padding(dp_20)
}
