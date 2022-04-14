package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGray


@Composable
fun SearchBarComponent(
    elevation: Dp = 15.dp,
    shape: RoundedCornerShape = RoundedCornerShape(15.dp)
) {
    Card(
        shape = shape,
        elevation = elevation
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Search", color = PrimaryGray)
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                backgroundColor = Color.White
            ),
            shape = shape,
        )
    }

}

@Composable
@Preview
fun PreviewSearchBarComponent() {
    ComposeAcademyTheme {
        Surface {
            SearchBarComponent()
        }
    }
}

