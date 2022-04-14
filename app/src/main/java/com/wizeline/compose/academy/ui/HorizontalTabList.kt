package com.wizeline.compose.academy.ui

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
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant

@Composable
fun HorizontalTabList(
    list: List<String>,
    selectedIndex: Int = 0
) {

    LazyRow() {
        itemsIndexed(list) { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item,
                    style = MaterialTheme.typography.body1.copy(color = if (selectedIndex == index) MaterialTheme.colors.primary else PrimaryGravyVariant),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                )
                if (selectedIndex == index) {
                    Box(
                        modifier = Modifier
                            .size(5.dp)
                            .background(color = MaterialTheme.colors.primary, shape = CircleShape)
                    ) {

                    }
                }
            }
        }
    }
}