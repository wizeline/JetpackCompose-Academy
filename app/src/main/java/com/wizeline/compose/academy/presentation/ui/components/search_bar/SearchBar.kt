package com.wizeline.compose.academy.presentation.ui.components.search_bar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.presentation.ui.components.ranking.Ranking
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun SearchBar() {

    Card(
        elevation= dimensionResource(id = R.dimen.fifteen),
        shape = MaterialTheme.shapes.medium
    ) {
        TextField(value = stringResource(id = R.string.empty_string),
            onValueChange = {},
            placeholder = {
                Text(text = stringResource(id = R.string.label_search))
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = stringResource(id = R.string.label_search))
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            shape = MaterialTheme.shapes.medium)
    }
}

@Preview
@Composable
fun PreviewSearchBar(){
    ComposeAcademyTheme {
        Surface{
            SearchBar()
        }
    }
}