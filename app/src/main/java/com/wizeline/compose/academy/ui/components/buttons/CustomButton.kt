package com.wizeline.compose.academy.ui.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    title: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold
        )
    }
}