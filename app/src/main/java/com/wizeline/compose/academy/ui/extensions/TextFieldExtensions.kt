package com.wizeline.compose.academy.ui.extensions

import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun textWithOutBorders() = TextFieldDefaults.outlinedTextFieldColors(
    unfocusedBorderColor = Color.Transparent,
    disabledBorderColor = Color.Transparent,
    errorBorderColor = Color.Transparent,
    focusedBorderColor = Color.Transparent
)
