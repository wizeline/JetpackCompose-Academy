package com.wizeline.compose.academy.presentation.ui.screens.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.Place
import com.wizeline.compose.academy.domain.model.PlacePictures
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.components.spacer.CustomWidthSpacer
import com.wizeline.compose.academy.presentation.ui.components.gallery.ImageGalleryImage
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun ImageGalleryScreen(id: Int){

    val place : Place? = getPlaces().find { it.id == id }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ){
        Image(painter = painterResource(id = place!!.imagesList[0].imageId),
              contentDescription = null,
              contentScale = ContentScale.Crop,
              modifier = Modifier.fillMaxSize())
        Box(modifier = Modifier.padding(dimensionResource(id = R.dimen.ten))){
            Column(
                modifier= Modifier
                    .background(
                        color = Color.White
                    )
                    .padding(dimensionResource(id = R.dimen.five))
            ){
                for (i in 1 until place!!.imagesList.size){
                    ImageGalleryImage(imageID = place.imagesList[i].imageId)
                    CustomWidthSpacer()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewImageGalleryScreen(){
    ComposeAcademyTheme() {
        Surface {
            ImageGalleryScreen(getPlaces()[0].id)
        }
    }
}