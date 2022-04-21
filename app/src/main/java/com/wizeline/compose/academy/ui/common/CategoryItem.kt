package com.wizeline.compose.academy.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.Dimens

@Composable
fun CategoryItem(index: Int) {
    Card(
        elevation = 10.dp,
        modifier = Modifier.padding(Dimens.ITEM_SEPARATION_NORMAL.size),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(Dimens.ITEM_SEPARATION_NORMAL.size)
        ) {
            Image(
                painter = when (index) {
                    0 -> painterResource(id = R.drawable.mountain)
                    1 -> painterResource(id = R.drawable.beach)
                    2 -> painterResource(id = R.drawable.forest)
                    else -> painterResource(id = R.drawable.mountain)
                },
                contentDescription = "category image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = when (index) {
                    0 -> stringResource(id = R.string.label_mountains)
                    1 -> stringResource(id = R.string.label_beach)
                    2 -> stringResource(id = R.string.label_forest)
                    else -> stringResource(id = R.string.label_mountains)
                },
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = Dimens.ITEM_SEPARATION_NORMAL.size)
            )
        }
    }
}

@Preview
@Composable
fun previewCategoryItem() {
    MaterialTheme {
        Surface {
            CategoryItem(index = 0)
        }
    }
}