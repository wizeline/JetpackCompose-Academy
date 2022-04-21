package com.wizeline.compose.academy.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.Dimens

@Composable
fun CircularButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(Dimens.ITEM_SEPARATION_NORMAL.size)
            .background(
                MaterialTheme.colors.surface,
                shape = CircleShape
            )
            .clickable { onClick() }
    ) {
        Icon(
            icon,
            contentDescription = "like button",
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Preview
@Composable
fun previewCircularButton() {
    MaterialTheme {
        Surface {
            CircularButton(Icons.Default.FavoriteBorder) {}
        }
    }
}