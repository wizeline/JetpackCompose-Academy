package com.wizeline.compose.academy.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.ui.theme.PrimaryGray

@Composable
fun CustomPlacePrice(price: Int) {
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        ) {
            append("$${price}")
        }
        withStyle(
            style = SpanStyle(
                color = PrimaryGray,
                fontSize = 14.sp
            )
        ) {
            append("/")
            append("night")
        }
    })
}