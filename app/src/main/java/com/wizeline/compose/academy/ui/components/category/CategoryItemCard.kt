package com.wizeline.compose.academy.ui.components.category

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.models.Category
import com.wizeline.compose.academy.domain.DataGenerator
import com.wizeline.compose.academy.ui.components.common.CustomSpacer
import com.wizeline.compose.academy.ui.components.common.SpacerDimens
import com.wizeline.compose.academy.ui.components.common.SpacerOrientation
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.dimen_10dp
import com.wizeline.compose.academy.ui.theme.dimen_50dp
import com.wizeline.compose.academy.ui.theme.dimen_5dp

@Composable
fun CategoryItem(
    category: Category,
) {
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.surface,
                shape = MaterialTheme.shapes.small,
            )
            .padding(dimen_5dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(dimen_10dp)
        ) {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = category.title,
                modifier = Modifier
                    .size(dimen_50dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            CustomSpacer(
                spacerDimens = SpacerDimens.EXTRA_SMALL,
                spacerOrientation = SpacerOrientation.HORIZONTAL
            )
            Text(text = category.title)
        }
    }
}

@Composable
@Preview(name = "light_mode")
@Preview(name ="dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewCategoryItem() {
    ComposeAcademyTheme {
        Surface {
            CategoryItem(
                DataGenerator.categoryList[0]
            )
        }
    }
}
