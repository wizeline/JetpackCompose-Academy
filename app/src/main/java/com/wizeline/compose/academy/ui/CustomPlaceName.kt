package com.wizeline.compose.academy.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun CustomPlaceName(name: String, style: TextStyle = MaterialTheme.typography.h6) {
    Text(
        text = name,
        style = style.copy(fontWeight = FontWeight.Bold)
    )
}