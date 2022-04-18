package com.wizeline.compose.academy.ui.components.buttons

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.tools.dp_10
import com.wizeline.compose.academy.tools.dp_5
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CircleIconButton(
    icon: ImageVector,
) {
    Box(
        modifier = Modifier.padding(dp_10)
    ) {
        Box(
            modifier = Modifier
                .padding(dp_5)
                .background(
                    color = Color.White,
                    shape = CircleShape,
                )
        ) {
            Icon(
                icon,
                contentDescription = stringResource(id = R.string.iconDescription),
                modifier = Modifier.padding(dp_5),
                tint = MaterialTheme.colors.onSecondary
            )
        }
    }
}

@Preview
@Composable
private fun CircleIconButtonPreview() {
    ComposeAcademyTheme {
        Surface {
            CircleIconButton(
                Icons.Default.FavoriteBorder
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CircleIconButtonDarkPreview() {
    CircleIconButtonPreview()
}
