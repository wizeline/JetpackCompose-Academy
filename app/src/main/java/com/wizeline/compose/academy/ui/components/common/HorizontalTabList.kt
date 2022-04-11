package com.wizeline.compose.academy.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.wizeline.compose.academy.ui.extensions.getGrayVariantColor
import com.wizeline.compose.academy.ui.theme.*

@Composable
fun HorizontalTabList(
    list: List<String>,
    selectedIndex: Int = 0
) {

    LazyRow {
        itemsIndexed(list) { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item,
                    style = MaterialTheme.typography.body1.copy(
                        color = if (selectedIndex == index) MaterialTheme.colors.primary else getGrayVariantColor(),
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(
                        horizontal = dimen_20dp,
                        vertical = dimen_10dp
                    )
                )
                if (selectedIndex == index){
                    Box(
                        modifier = Modifier
                            .size(dimen_5dp)
                            .background(
                                color = MaterialTheme.colors.primary,
                                shape = CircleShape
                            )
                    ){}
                }
            }
        }
    }
}
