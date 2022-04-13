package com.wizeline.compose.academy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.model.Category
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CategoryItemCard(category: Category) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .clip(MaterialTheme.shapes.medium),
        elevation = 15.dp
    ) {
        Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = category.imageResourceId),
                contentDescription = "Category image",
                modifier = Modifier
                    .size(50.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))
            Text(text = category.name)
        }
    }
}

@Composable
@Preview
fun PreviewCategoryItemCard() {
    ComposeAcademyTheme {
        Surface {
            CategoryItemCard(
                Category(
                    "Mountain",
                    R.drawable.mountain
                )
            )
        }
    }
}