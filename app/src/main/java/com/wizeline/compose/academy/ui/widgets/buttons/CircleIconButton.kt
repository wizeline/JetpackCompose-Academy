package com.wizeline.compose.academy.ui.widgets.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CircleIconButton(
  icon: ImageVector = Icons.Default.FavoriteBorder
) {
  Box(modifier = Modifier.padding(10.dp)) {

    Box(
      modifier = Modifier
        .padding(5.dp)
        .background(
          color = Color.White,
          shape = CircleShape
        )
    ) {
      Icon(
        imageVector = icon,
        contentDescription = "Icon",
        modifier = Modifier.padding(5.dp)
      )
    }

  }
}

@Composable
@Preview(showBackground = true)
fun PreviewCircleIconButton() {
  ComposeAcademyTheme {
    androidx.compose.material.Surface {
      CircleIconButton()
    }
  }
}