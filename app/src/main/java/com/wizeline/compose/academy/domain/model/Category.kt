package com.wizeline.compose.academy.domain.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.wizeline.compose.academy.R

data class Category(
    var imageId: Int,
    var name: String
)

@Composable
fun getCategories(): List<Category> {

    val context = LocalContext.current

    return listOf(
        Category(
            context.resources.getIdentifier("mountain", "drawable", context.packageName),
            stringResource(id = R.string.label_mountains)
        ),
        Category(
            context.resources.getIdentifier("beach", "drawable", context.packageName),
            stringResource(id = R.string.label_beach)
        ),
        Category(
            context.resources.getIdentifier("forest", "drawable", context.packageName),
            stringResource(id = R.string.label_forest)
        ),
    )
}
