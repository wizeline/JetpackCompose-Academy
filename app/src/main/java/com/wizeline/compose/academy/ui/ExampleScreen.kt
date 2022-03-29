package com.wizeline.compose.academy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun ExampleScreen() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Red)
            .clip(CircleShape)
        ) {}
        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Blue)

        ) {}

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Yellow)

        ) {}
    }
}


@Composable
@Preview
fun PreviewExampleScreen() {
    ComposeAcademyTheme {
        Surface {
            ExampleScreen()
        }
    }
}
