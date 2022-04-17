package com.wizeline.compose.academy.ui.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R

@Composable
fun CustomSearchBar(){
    Card(
        elevation = 15.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = stringResource(id = R.string.label_search))
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "search")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            shape = MaterialTheme.shapes.medium
        )
    }
}