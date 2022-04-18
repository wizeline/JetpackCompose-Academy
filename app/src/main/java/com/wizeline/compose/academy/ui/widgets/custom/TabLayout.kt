package com.wizeline.compose.academy.ui.widgets.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant

@Composable
fun TabLayout(
  items: List<String> = emptyList(),
  selectedItem: Int = 0
) {
  LazyRow {
    itemsIndexed(items) { index, item ->
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {

        Text(
          text = item,
          style = MaterialTheme.typography.body1.copy(
            color = if (selectedItem == index) MaterialTheme.colors.primary else PrimaryGravyVariant,
            fontWeight = FontWeight.Bold
          ),
          modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )

        if (selectedItem == index) {
          Box(
            modifier = Modifier
              .size(5.dp)
              .background(
                color = MaterialTheme.colors.primary,
                shape = CircleShape
              )
          )
        }
      }
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewTabLayout() {
  ComposeAcademyTheme {
    Surface {
      TabLayout()
    }
  }
}