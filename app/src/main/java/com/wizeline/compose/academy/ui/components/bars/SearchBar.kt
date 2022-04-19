package com.wizeline.compose.academy.ui.components.bars

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.tools.dp_15
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun SearchBar() {
    Card(
        elevation = dp_15,
        shape = MaterialTheme.shapes.medium,
    ) {
        TextField(
            value = stringResource(id = R.string.emptyString),
            onValueChange = {},
            placeholder = {
                Text(
                    text = stringResource(id = R.string.txtSearch),
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.txtSearch),
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
            ),
            shape = MaterialTheme.shapes.medium,
        )
    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    ComposeAcademyTheme {
        Surface {
            SearchBar()
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun SearchBarDarkPreview() {
    SearchBarPreview()
}
