package com.wizeline.compose.academy.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(modifier: Modifier, label: String) {
    Button(onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.medium, modifier = modifier) {
        Text(
            text = label,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold
        )
    }
}