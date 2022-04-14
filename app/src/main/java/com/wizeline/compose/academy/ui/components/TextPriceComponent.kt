package com.wizeline.compose.academy.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun TextPriceComponent(
    modifier: Modifier = Modifier,
    price:Int = 1000,
    time:String = "night"
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            ) {
                append("$")
                append(price.toString())
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Gray
                )
            ) {
                append("/")
                append(time)
            }
        },
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Composable
@Preview
fun PreviewTextPrice(){
    ComposeAcademyTheme {
        Surface {
            TextPriceComponent()
        }
    }
}