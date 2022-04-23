package com.wizeline.compose.academy.presentation.ui.components.place

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.presentation.ui.theme.PrimaryGray

@Composable
fun PlaceItemPrice(price: String){
    Text(text = buildAnnotatedString {
        withStyle( style= SpanStyle(
            color= MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        ){
            append(price)
        }
        withStyle(style= SpanStyle(
            color= PrimaryGray
        )
        ){
            append(stringResource(id = R.string.slash))
            append(stringResource(id = R.string.label_night))
        }
    })
}

@Preview
@Composable
fun PreviewPlaceItemPrice(){
    ComposeAcademyTheme {
        Surface{
            PlaceItemPrice(price= getPlaces()[0].price)
        }
    }
}
