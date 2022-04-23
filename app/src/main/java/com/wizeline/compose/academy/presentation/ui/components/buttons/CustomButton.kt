package com.wizeline.compose.academy.presentation.ui.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.presentation.ui.screens.util.Screen

@Composable
fun CustomButton(title : String,
                 modifier : Modifier = Modifier,
                 navController: NavController){
    Button(onClick = { navController.navigate(Screen.HomeScreen.route)},
           shape= MaterialTheme.shapes.medium,
           modifier = modifier.padding(dimensionResource(id = R.dimen.five))) {
        Text(text = title,
            modifier= Modifier.padding(dimensionResource(id = R.dimen.eight)),
            fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun PreviewCustomButton(){
    CustomButton(title = "myButton", navController = rememberNavController())
}