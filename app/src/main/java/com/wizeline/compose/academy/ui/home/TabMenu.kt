package com.wizeline.compose.academy.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.Dimens

@Composable
fun TabsMenu(elements: Array<String>) {
    LazyRow(
        content = {
            for (element in elements) {
                var chosen = false
                if (element == "Hotels" || element == "Overview") chosen = true
                item {
                    TabMenuItem(title = element, chosen = chosen)
                }
            }
        },
        modifier = Modifier.padding(top = Dimens.ITEM_SEPARATION_NORMAL.size)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
}

@Composable
fun TabMenuItem(title: String, chosen: Boolean) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(Dimens.ITEM_SEPARATION_SMALL.size)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1.copy(
                color = if(chosen) MaterialTheme.colors.primary else Color.Gray,
                fontWeight = FontWeight.SemiBold
            ),
        )
        if (chosen) {
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = CircleShape
                    )
            ){}
        }
    }
}

@Preview
@Composable
fun PreviewTabMenuItem() {
    ComposeAcademyTheme {
        Surface {
            TabsMenu(tab_options)
        }
    }
}