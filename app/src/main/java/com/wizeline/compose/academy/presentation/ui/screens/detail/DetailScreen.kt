package com.wizeline.compose.academy.presentation.ui.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.Place
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.DetailCardContent
import com.wizeline.compose.academy.presentation.ui.components.buttons.CircleIconButton
import com.wizeline.compose.academy.presentation.ui.components.tab_list.HorizontalTabList
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun DetailScreen(
        id: Int = 1,
        navController: NavController
){
    val size = LocalConfiguration.current
    val height = size.screenHeightDp * 0.5
    val contentHeight = size.screenHeightDp * 0.63

    val place : Place? = getPlaces().find { it.id == id }

    Box(modifier= Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter) {
        Box(modifier= Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(place?.imageId ?: 0),
                    contentDescription = stringResource(id = R.string.label_header),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleIconButton(icon = Icons.Default.ArrowBack, navController = navController)
                    CircleIconButton(icon = Icons.Default.FavoriteBorder, navController = navController)
                }
            }
        }
        DetailCardContent(modifier= Modifier
                            .fillMaxWidth()
                            .height(contentHeight.dp),
                          place= place!!,
                          navController = navController)
    }
}

@Preview
@Composable
fun PreviewDetailScreen(){
    ComposeAcademyTheme {
        Surface{
            DetailScreen(navController= rememberNavController())
        }
    }
}