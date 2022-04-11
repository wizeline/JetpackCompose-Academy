package com.wizeline.compose.academy.ui.extensions

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant
import com.wizeline.compose.academy.ui.theme.PrimaryGray

@Composable
fun getGrayColor(
    isDarkMode: Boolean = isSystemInDarkTheme()
): Color {
    return if (isDarkMode) {
        Color.White
    } else {
        PrimaryGray
    }
}


@Composable
fun getGrayVariantColor(
    isDarkMode: Boolean = isSystemInDarkTheme()
): Color {
    return if (isDarkMode) {
        Color.White
    } else {
        PrimaryGravyVariant
    }
}
