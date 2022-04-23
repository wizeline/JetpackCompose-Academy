package com.wizeline.compose.academy.presentation.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun CircleIconButton(
    icon: ImageVector,
    navController: NavController
){
    val favorite = remember{
        mutableStateOf(false)
    }
    Box(Modifier.padding(dimensionResource(id = R.dimen.five))) {
        Box(
            modifier= Modifier
                .padding(dimensionResource(id = R.dimen.five))
                .background(
                    color = Color.White,
                    shape = CircleShape
                ),
        ){

            IconButton(onClick = {
                if(icon == Icons.Filled.ArrowBack) navController.navigateUp() else favorite.value = true
            }) {
                Icon(
                    imageVector = if(icon.name == "Filled.ArrowBack") Icons.Default.ArrowBack else Icons.Default.Favorite,
                    contentDescription = stringResource(id = R.string.label_favorite),
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.three)),
                    tint= if(favorite.value) Color.Red else Color.Gray)
                }
        }
    }
}

@Composable
@Preview
fun PreviewCircleIconButton(){
    ComposeAcademyTheme{
        Surface {
            CircleIconButton(icon = Icons.Default.Favorite, navController = rememberNavController())
        }
    }
}
