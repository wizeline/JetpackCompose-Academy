package com.wizeline.compose.academy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val DarkColorPalette = ExtendedColors(
    material = darkColors(
        primary = PrimaryBlue,
        primaryVariant = PrimaryBlueVariant,
        secondary = secondaryBlue
    ),
    PrimaryGravyVariant = PrimaryDarkGravyVariant,
    PrimaryGray = PrimaryDarkGray
)

private val LightColorPalette = ExtendedColors(
    material = lightColors(
        primary = PrimaryBlue,
        primaryVariant = PrimaryBlueVariant,
        secondary = secondaryBlue
    ),
    PrimaryGravyVariant = PrimaryLightGravyVariant,
    PrimaryGray = PrimaryLightGray
)

private val LocalColors = staticCompositionLocalOf { LightColorPalette }

@Composable
fun ComposeAcademyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colors = colors.material,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

val MaterialTheme.extendedColors: ExtendedColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
