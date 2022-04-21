package com.wizeline.compose.academy.ui.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.Dimens

@Composable
fun SearchBar(
    onValueChange: (String) -> Unit
) {
    Card(
        elevation = 10.dp,
        backgroundColor = Color.White,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
    ) {
        TextField(
            value = "",
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.label_search)
                )
            },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "search icon",
                )
            },
        )
    }
}

@Preview
@Composable
fun PreviewSearch() {
    ComposeAcademyTheme {
        Surface {
            SearchBar(){}
        }
    }
}