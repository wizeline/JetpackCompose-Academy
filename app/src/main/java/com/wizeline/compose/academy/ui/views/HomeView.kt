package com.wizeline.compose.academy.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGray
import com.wizeline.compose.academy.ui.utils.CustomHorizontalTabs
import com.wizeline.compose.academy.ui.utils.CustomSearchBar

@Composable
fun HomeView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.label_explore),
                style = MaterialTheme.typography.h4.copy(
                    color = PrimaryGray,
                    fontWeight = FontWeight.Bold
                )
            )

            Icon(
                Icons.Default.Notifications,
                contentDescription = "notifications",
                tint = PrimaryGray
            )
        }

        Text(
            text = stringResource(id = R.string.label_explore_description),
            style = MaterialTheme.typography.body1.copy(
                color = PrimaryGray
            )
        )

        CustomSearchBar()
        
        CustomHorizontalTabs(list = listOf(
            stringResource(id = R.string.label_hotels),
            stringResource(id = R.string.label_things_to_do),
            stringResource(id = R.string.label_events),
            stringResource(id = R.string.label_sights)
        ))
    }
}

@Composable
@Preview
fun HomeViewPreview() {
    ComposeAcademyTheme() {
        Surface {
            HomeView()
        }
    }
}