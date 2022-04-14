package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.model.Category
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CategoryItem(category: Category){
    Card(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        shape =  RoundedCornerShape(dimensionResource(id = R.dimen.rounded_large)),
        elevation = dimensionResource(id = R.dimen.elevation_default)
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = category.description,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_large))
                    .width(dimensionResource(id = R.dimen.category_image_size))
                    .height(dimensionResource(id = R.dimen.category_image_size))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_large))),
                contentScale = ContentScale.Crop,

                )
            CustomWidthSpacer(SpacerSize.MEDIUM)
            Text(
                text = category.name,
                style = MaterialTheme.typography.h6
            )
            CustomWidthSpacer(SpacerSize.LARGE)
        }
    }
}

@Composable
@Preview
fun PreviewCategoryItem() {
    ComposeAcademyTheme {
        Surface {

            CategoryItem(
                category = Category(
                    image = R.drawable.forest,
                    name = stringResource(id = R.string.label_forest),
                    description = stringResource(id = R.string.label_place_description)
                )
            )
        }
    }
}