package com.wizeline.compose.academy.ui.components.place

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.DataGenerator
import com.wizeline.compose.academy.ui.theme.dimen_10dp
import com.wizeline.compose.academy.ui.theme.dimen_200dp


@Composable
fun PlaceImageGallery() {
    LazyRow {
        items(DataGenerator.imageGalleryList) {
            Image(
                painter = painterResource(id = it),
                contentDescription = "place_item_gallery",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimen_200dp)
                    .padding(dimen_10dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}
