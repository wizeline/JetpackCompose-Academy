package com.wizeline.compose.academy.ui.widgets.custom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.widgets.custom.SpacerSize.EXTRA_LARGE
import com.wizeline.compose.academy.ui.widgets.custom.SpacerSize.EXTRA_SMALL
import com.wizeline.compose.academy.ui.widgets.custom.SpacerSize.LARGE
import com.wizeline.compose.academy.ui.widgets.custom.SpacerSize.MEDIUM
import com.wizeline.compose.academy.ui.widgets.custom.SpacerSize.SMALL
import com.wizeline.compose.academy.ui.widgets.custom.SpacerType.HEIGHT
import com.wizeline.compose.academy.ui.widgets.custom.SpacerType.WIDTH

@Composable
fun CustomSpacer(
  spacerSize: SpacerSize = MEDIUM,
  spacerType: SpacerType = HEIGHT
) {
  val size = when (spacerSize) {
    EXTRA_SMALL -> 5.dp
    SMALL -> 10.dp
    MEDIUM -> 15.dp
    LARGE -> 20.dp
    EXTRA_LARGE -> 25.dp
  }

  Spacer(
    modifier = when (spacerType) {
      HEIGHT -> Modifier.height(size)
      WIDTH -> Modifier.width(size)
    }
  )
}

enum class SpacerType {
  HEIGHT,
  WIDTH
}

enum class SpacerSize {
  EXTRA_SMALL,
  SMALL,
  MEDIUM,
  LARGE,
  EXTRA_LARGE
}