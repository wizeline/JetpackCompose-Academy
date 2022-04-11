package com.wizeline.compose.academy.ui.components.common

import android.content.res.Configuration
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.dimen_10dp
import com.wizeline.compose.academy.ui.theme.dimen_5dp

@Composable
fun CircleIconButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
   Box(
       modifier = Modifier.padding(dimen_10dp)
   ) {
       Box(
           modifier = Modifier
               .padding(dimen_5dp)
               .background(
                   color = MaterialTheme.colors.surface,
                   shape = CircleShape
               )
               .clickable { onClick() }
       ) {
           Icon(
               icon,
               contentDescription = "button_icon",
               modifier = Modifier.padding(dimen_5dp)
           )
       }
   }
}


@Composable
@Preview(name = "light_mode")
@Preview(name ="dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewCircleIconButton() {
   ComposeAcademyTheme {
       Surface {
           CircleIconButton(icon = Icons.Default.FavoriteBorder) {}
       }
   }
}

