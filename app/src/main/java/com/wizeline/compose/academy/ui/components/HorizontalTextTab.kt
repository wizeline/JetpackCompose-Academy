package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryBlue

@Composable
fun HorizontalTextTab(selectedItem: Int = 0, titles: List<String>){
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(titles){ index, title ->
            if (selectedItem == index) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h5.copy(
                            color = PrimaryBlue
                        )
                    )
                    Box(
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.padding_small))
                            .background(
                                color = MaterialTheme.colors.primary,
                                shape = CircleShape
                            )
                    ){

                    }
                }
            }
            else{
                Text(
                    text = title,
                    style = MaterialTheme.typography.h5.copy(
                        color = Color.Gray
                    )
                )
            }
            CustomWidthSpacer(SpacerSize.SMALL)
        }
    }
}

@Composable
@Preview
fun PreviewTextTab() {
    val titles = listOf("Overview", "Details", "Costs")
    ComposeAcademyTheme {
        Surface {
            HorizontalTextTab(selectedItem = 0, titles = titles)
        }
    }
}
