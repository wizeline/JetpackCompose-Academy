package com.wizeline.compose.academy.ui.widgets.textfields

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CardTitle(
  title: String = "Title",
  style: TextStyle = MaterialTheme.typography.h6
) {
  Text(
    text = title,
    style = style.copy(fontWeight = FontWeight.Bold)
  )
}

@Composable
@Preview
fun PreviewCardTitle() {
  ComposeAcademyTheme {
    Surface {
      CardTitle()
    }
  }
}