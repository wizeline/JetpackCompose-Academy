package com.wizeline.compose.academy.presentation.ui.components.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.presentation.ui.components.search_bar.SearchBar
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun CustomHeightSpacer(
    spacerHeight: SpacerHeight = SpacerHeight.MEDIUM
) {
    val height = when(spacerHeight){

        SpacerHeight.EXTRA_SMALL -> dimensionResource(id = R.dimen.five)
        SpacerHeight.SMALL -> dimensionResource(id = R.dimen.ten)
        SpacerHeight.MEDIUM -> dimensionResource(id = R.dimen.fifteen)
        SpacerHeight.LARGE -> dimensionResource(id = R.dimen.twenty)
        SpacerHeight.EXTRA_LARGE -> dimensionResource(id = R.dimen.twenty_five)
    }
    Spacer(modifier= Modifier.height(height))
}

@Composable
fun CustomWidthSpacer(
    spacerWidth: SpacerWidth = SpacerWidth.MEDIUM
) {
    val width = when(spacerWidth){
        SpacerWidth.EXTRA_SMALL -> dimensionResource(id = R.dimen.five)
        SpacerWidth.SMALL -> dimensionResource(id = R.dimen.ten)
        SpacerWidth.MEDIUM -> dimensionResource(id = R.dimen.fifteen)
        SpacerWidth.LARGE -> dimensionResource(id = R.dimen.twenty)
        SpacerWidth.EXTRA_LARGE -> dimensionResource(id = R.dimen.twenty_five)
    }
    Spacer(modifier= Modifier.height(width))
}

enum class SpacerHeight{
    EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
}

enum class SpacerWidth{
    EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
}

@Preview
@Composable
fun PreviewCustomHeightSpacer(){
    ComposeAcademyTheme {
        Surface{
            CustomHeightSpacer()
        }
    }
}