package com.wizeline.compose.academy.ui.components.cards

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.models.Category
import com.wizeline.compose.academy.tools.dp_0
import com.wizeline.compose.academy.tools.dp_10
import com.wizeline.compose.academy.tools.dp_5
import com.wizeline.compose.academy.tools.dp_50
import com.wizeline.compose.academy.ui.components.others.CustomWidthSpacer
import com.wizeline.compose.academy.ui.components.others.SpacerWidth
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CategoryItemCard(
    category: Category,
    placeHolder: Int = R.drawable.placeholder
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .background(
                color = Color.White,
            )
            .padding(dp_5),
        elevation = dp_0,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(dp_10)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = category.imageUrl,
                    builder = {
                        placeholder(placeHolder)
                    }),
                contentDescription = stringResource(id = R.string.placeImageDescription),
                modifier = Modifier
                    .size(dp_50)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )

            CustomWidthSpacer(
                spacerWidth = SpacerWidth.EXTRA_SMALL,
            )
            Text(
                text = category.name,
            )
        }
    }
}

@Preview
@Composable
private fun CategoryItemCardPreview() {
    ComposeAcademyTheme {
        Surface {
            CategoryItemCard(
                Category(1, "Mountains", ""),
                R.drawable.mountain
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CategoryItemCardDarkPreview() {
    CategoryItemCardPreview()
}
