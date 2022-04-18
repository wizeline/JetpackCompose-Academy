package com.wizeline.compose.academy.ui.widgets.custom

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CustomSearchBar(
  elevation: Dp = 4.dp,
  shape: RoundedCornerShape = RoundedCornerShape(15.dp),
  @StringRes textId: Int = R.string.label_search
) {
  Card(
    shape = MaterialTheme.shapes.medium,
    elevation = elevation
  ) {

    TextField(
      value = stringResource(id = textId),
      onValueChange = {},
      leadingIcon = {
        Icon(
          imageVector = Icons.Default.Search,
          contentDescription = "Search Icon"
        )
      },
      modifier = Modifier.fillMaxWidth(),
      colors = TextFieldDefaults.outlinedTextFieldColors(
        backgroundColor = Color.White,
        disabledBorderColor = Color.Transparent,
        errorBorderColor = Color.Red,
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent
      ),
      shape = shape
    )

  }
}

@Composable
@Preview(showBackground = true)
fun PreviewCustomSearchBar() {
  ComposeAcademyTheme {
    Surface {
      CustomSearchBar()
    }
  }
}