package com.wizeline.compose.academy.ui.components.list_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.components.utils.CustomWidthSpacer
import com.wizeline.compose.academy.ui.components.utils.SpacerSize

@Composable
fun CategoryItemView() {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .background(
                color = Color.White
            )
            .padding(5.dp),
        elevation = 0.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mountain),
                contentDescription = "place_image",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            CustomWidthSpacer(
                spacerSize = SpacerSize.EXTRA_SMALL
            )

            Text(
                text = stringResource(id = R.string.label_mountains)
            )
        }
    }
}