package com.wizeline.compose.academy.ui.components.others

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.tools.*
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CustomHeightSpacer(
    spacerHeight: SpacerHeight = SpacerHeight.MEDIUM
) {
    val height = when (spacerHeight) {
        SpacerHeight.EXTRA_SMALL -> dp_5
        SpacerHeight.SMALL -> dp_10
        SpacerHeight.MEDIUM -> dp_15
        SpacerHeight.LARGE -> dp_20
        SpacerHeight.EXTRA_LARGE -> dp_25
    }

    Spacer(modifier = Modifier.height(height))
}

@Composable
fun CustomWidthSpacer(
    spacerWidth: SpacerWidth = SpacerWidth.MEDIUM
) {
    val width = when (spacerWidth) {
        SpacerWidth.EXTRA_SMALL -> dp_5
        SpacerWidth.SMALL -> dp_10
        SpacerWidth.MEDIUM -> dp_15
        SpacerWidth.LARGE -> dp_20
        SpacerWidth.EXTRA_LARGE -> dp_25
    }

    Spacer(modifier = Modifier.width(width))
}

enum class SpacerHeight {
    EXTRA_SMALL,
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE,
}

enum class SpacerWidth {
    EXTRA_SMALL,
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE,
}

@Preview
@Composable
private fun CustomHeightSpacerPreview() {
    ComposeAcademyTheme {
        Surface {
            CustomHeightSpacer(SpacerHeight.MEDIUM)
        }
    }
}

@Preview
@Composable
private fun CustomWidthSpacerPreview() {
    ComposeAcademyTheme {
        Surface {
            CustomWidthSpacer(SpacerWidth.MEDIUM)
        }
    }
}
