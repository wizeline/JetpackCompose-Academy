package com.wizeline.compose.academy.presentation.ui.components.tab_list

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.presentation.ui.components.spacer.CustomHeightSpacer
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.presentation.ui.theme.PrimaryGravyVariant

@Composable
fun HorizontalTabList(
    list: List<String>,
    selectedIndex: Int = 0
){

    LazyRow{
        itemsIndexed(list){ index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = item,
                style= MaterialTheme.typography.body1.copy(
                    color = if(selectedIndex == index) MaterialTheme.colors.primary else PrimaryGravyVariant,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.twenty),
                    vertical = dimensionResource(id = R.dimen.ten)
                ))
                if(selectedIndex == index){
                    Box(
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.five))
                            .background(
                                color = MaterialTheme.colors.primary,
                                shape = CircleShape
                            )
                    ){

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHorizontalTabList(){
    ComposeAcademyTheme {
        Surface{
            HorizontalTabList(list = listOf(
                stringResource(id = R.string.label_hotels),
                stringResource(id = R.string.label_things_to_do),
                stringResource(id = R.string.label_events),
                stringResource(id = R.string.label_sights)
            ))
        }
    }
}