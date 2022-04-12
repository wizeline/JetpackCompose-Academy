package com.wizeline.compose.academy.ui.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R

@Composable
fun CustomButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.label_sign_in),
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold
        )
    }
}