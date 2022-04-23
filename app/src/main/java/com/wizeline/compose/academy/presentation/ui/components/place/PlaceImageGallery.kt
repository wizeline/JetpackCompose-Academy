package com.wizeline.compose.academy.presentation.ui.components.place

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.PlacePictures
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun PlaceImageGallery(places: List<PlacePictures>){

    LazyRow{
        items(places.size){ index ->
            Image(painter = painterResource(id = places[index].imageId),
                contentDescription = stringResource(id = R.string.label_place),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.two_hundred))
                    .padding(dimensionResource(id = R.dimen.ten))
                    .clip(MaterialTheme.shapes.medium))
        }
    }
}

@Preview
@Composable
fun PreviewPlaceImageGallery(){
    ComposeAcademyTheme {
        Surface{
            PlaceImageGallery(places = getPlaces()[0].imagesList)
        }
    }
}