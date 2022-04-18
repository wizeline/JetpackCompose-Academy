package com.wizeline.compose.academy.ui.components.tabs

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.models.Section
import com.wizeline.compose.academy.tools.dp_10
import com.wizeline.compose.academy.tools.dp_20
import com.wizeline.compose.academy.tools.dp_5
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.extendedColors

@Composable
fun HorizontalTabList(
    list: List<Section>,
    selectedIndex: Int = 0,
) {
    LazyRow {
        itemsIndexed(list) { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.body1.copy(
                        color = if (selectedIndex == index) MaterialTheme.colors.primary else MaterialTheme.extendedColors.PrimaryGray,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier.padding(
                        horizontal = dp_20,
                        vertical = dp_10,
                    )
                )
                if (selectedIndex == index) {
                    Box(
                        modifier = Modifier
                            .size(dp_5)
                            .background(
                                color = MaterialTheme.colors.primary,
                                shape = CircleShape,
                            )
                    ) {

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HorizontalTabListPreview() {
    ComposeAcademyTheme {
        Surface {
            HorizontalTabList(list = listOf(
                Section(1, "Hotels"),
                Section(2, "Things to do"),
                Section(3, "Events"),
                Section(4, "Sights"),
                Section(5, "Other")
            ))
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun HorizontalTabListDarkPreview() {
    HorizontalTabListPreview()
}