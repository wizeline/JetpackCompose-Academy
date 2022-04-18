package com.wizeline.compose.academy.ui.widgets.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.models.CategoriesItem
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.widgets.custom.CustomSpacer
import com.wizeline.compose.academy.ui.widgets.custom.SpacerType.WIDTH

@Composable
fun CategoryItem(category: CategoriesItem = CategoriesItem()) {
  Card(
    shape = MaterialTheme.shapes.small,
    modifier = Modifier
      .background(color = Color.White)
      .padding(5.dp),
    elevation = 0.dp
  ) {

    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(10.dp)
    ) {

      Image(
        painter = painterResource(id = category.image),
        contentDescription = "Category image",
        modifier = Modifier
          .size(60.dp)
          .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop
      )

      CustomSpacer(spacerType = WIDTH)

      Text(text = category.name)
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewCategoryItem() {
  ComposeAcademyTheme {
    Surface {
      CategoryItem()
    }
  }
}