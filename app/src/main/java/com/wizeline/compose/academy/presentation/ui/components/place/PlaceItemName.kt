package com.wizeline.compose.academy.presentation.ui.components.place

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun PlaceItemName(
    name: String,
    style: TextStyle = MaterialTheme.typography.h6
){
    Text(text = name,
        style = style.copy(
            fontWeight = FontWeight.Bold
        ))
}

@Preview
@Composable
fun PreviewPlaceItemName(){
    ComposeAcademyTheme {
        Surface{
            PlaceItemName(name= getPlaces()[0].name)
        }
    }
}