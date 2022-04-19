package com.wizeline.compose.academy.ui.screens.dashboard

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.mock.MockData
import com.wizeline.compose.academy.models.FullModel
import com.wizeline.compose.academy.tools.dp_10
import com.wizeline.compose.academy.tools.dp_20
import com.wizeline.compose.academy.ui.components.others.CustomHeightSpacer
import com.wizeline.compose.academy.ui.components.bars.SearchBar
import com.wizeline.compose.academy.ui.components.cards.CategoryItemCard
import com.wizeline.compose.academy.ui.components.cards.PlaceItemCard
import com.wizeline.compose.academy.ui.components.tabs.HorizontalTabList
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.extendedColors

@Composable
fun DashboardScreen(
    model: FullModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dp_20),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(id = R.string.label_explore),
                style = MaterialTheme.typography.h4.copy(
                    color = MaterialTheme.extendedColors.PrimaryGray,
                    fontWeight = FontWeight.Bold,
                )
            )

            Icon(
                Icons.Default.Notifications,
                contentDescription = stringResource(id = R.string.notificationsDescription),
                tint = MaterialTheme.extendedColors.PrimaryGray,
            )
        }

        Text(
            text = stringResource(id = R.string.label_explore_description),
            style = MaterialTheme.typography.body1.copy(
                color = MaterialTheme.extendedColors.PrimaryGray,
            )
        )

        CustomHeightSpacer()

        SearchBar()

        CustomHeightSpacer()

        HorizontalTabList(
            list = model.sections
        )

        CustomHeightSpacer()

        LazyRow {
            itemsIndexed(model.places) { _, item ->
                PlaceItemCard(item)
            }
        }

        CustomHeightSpacer()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dp_10),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.txtCategories),
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Bold,
                )
            )

            Text(
                text = stringResource(id = R.string.txtSeeMore),
                style = MaterialTheme.typography.body2.copy(
                    color = MaterialTheme.colors.primary
                )
            )
        }

        CustomHeightSpacer()

        LazyRow {
            itemsIndexed(model.categories) { _, item ->
                CategoryItemCard(item)
            }
        }
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    ComposeAcademyTheme {
        Surface {
            val model = Gson().fromJson(MockData.mockJson, FullModel::class.java)
            DashboardScreen(model)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun DashboardScreenDarkPreview() {
    DashboardScreenPreview()
}