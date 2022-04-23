package com.wizeline.compose.academy.presentation.ui.components.ranking

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.wizeline.compose.academy.presentation.ui.theme.PrimaryGravyVariant
import com.wizeline.compose.academy.presentation.ui.theme.PrimaryOrange
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.components.place.PlaceItemPrice
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun Ranking(
    ranking: Int,
    reviews: Int,
    showLabel: Boolean = false
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        for (i in 1..ranking){
            Icon(Icons.Default.Star,
                 contentDescription = stringResource(id = R.string.label_ranking),
                 tint = PrimaryOrange)
        }
        Text(text= if(showLabel) "$reviews ${stringResource(id = R.string.label_reviews)}" else "$reviews",
             style= MaterialTheme.typography.body2.copy(
                 color= PrimaryGravyVariant
             )
        )
    }
}

@Preview
@Composable
fun PreviewRanking(){
    ComposeAcademyTheme {
        Surface{
            Ranking(ranking= 5, reviews= 1255)
        }
    }
}