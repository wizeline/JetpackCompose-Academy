package com.wizeline.compose.academy.ui.components.common

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.extensions.textWithOutBorders
import com.wizeline.compose.academy.ui.theme.dimen_15dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String = stringResource(id = R.string.label_search),
    onValueChange: (String) -> Unit
) {
    Card(
        elevation = dimen_15dp,
        shape = MaterialTheme.shapes.medium
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = placeHolder)
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = value)
            },
            modifier = modifier,
            colors = textWithOutBorders(),
            shape = MaterialTheme.shapes.medium
        )
    }
}
