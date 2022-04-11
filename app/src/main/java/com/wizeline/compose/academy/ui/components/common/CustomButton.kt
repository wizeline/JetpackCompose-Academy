package com.wizeline.compose.academy.ui.components.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.dimen_5dp

@Composable
fun CustomButton(
    title: String,
    modifier: Modifier = Modifier,
    onCLick: () -> Unit
) {
    Button(
        onClick = onCLick,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(dimen_5dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(dimen_5dp),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold
            )
        )
    }
}
