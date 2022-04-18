package com.wizeline.compose.academy.ui.widgets.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
  @StringRes resId: Int,
  modifier: Modifier = Modifier
) {
  Button(
    onClick = {/*TODO*/ },
    shape = MaterialTheme.shapes.medium,
    modifier = modifier.padding(5.dp)
  ) {
    Text(
      text = stringResource(id = resId),
      modifier = Modifier.padding(8.dp),
      fontWeight = FontWeight.Bold
    )
  }
}