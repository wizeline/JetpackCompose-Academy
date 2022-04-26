package com.wizeline.compose.academy.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.components.*
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGravyVariant

@Composable
fun DetailScreen (){

    val size = LocalConfiguration.current
    val height = size.screenHeightDp * 0.3
    val contentHeight = size.screenHeightDp * 0.73
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(height.dp),
                contentAlignment = Alignment.TopCenter
            ){
                Image(
                    painter = painterResource(id = R.drawable.hotel_image_2),
                    contentDescription = "header_image",
                    contentScale = ContentScale.Crop,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleIconButton(icon = Icons.Default.ArrowBack)
                    CircleIconButton(icon = Icons.Default.FavoriteBorder)
                }
            }
        }
        DetailsCardContent(
            modifier = Modifier.fillMaxWidth().height(contentHeight.dp)
        )
    }
}

@Composable
fun DetailsCardContent(modifier: Modifier = Modifier){
    Card(
        shape = RoundedCornerShape(
            topEnd = 30.dp,
            topStart = 30.dp
        ),
        elevation = 0.dp,
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ){
            item{
                CustomHeightSpacer()

                PlaceItemName(name = "La Casa de las Tortugas", style = MaterialTheme.typography.h5)

                CustomHeightSpacer()

                Ranking(showLabel = true)

                CustomHeightSpacer()

                PlaceItemAddress(address = "Av Dameron, 77310 Isla Holbox, Q.R., Mexico")

                CustomHeightSpacer()

                HorizontalTabList(list = listOf("Overview", "Details", "Costs"))

                CustomHeightSpacer()

                Text(
                    text = stringResource(id = R.string.label_place_description),
                    color = PrimaryGravyVariant
                )

                CustomHeightSpacer()

                Row{
                    Text(
                        text = "See more",
                        color = MaterialTheme.colors.primary
                    )
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "arrow_forward",
                        tint = MaterialTheme.colors.primary
                    )
                }

                CustomHeightSpacer()

                PlaceImageGallery()

                CustomHeightSpacer()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    PlaceItemPrice()
                    CustomButton(
                        "Check availability"
                    )
                }
            }
        }
    }
}

@Composable
fun PlaceImageGallery(){
    LazyRow( ){
        items(4){
            Image(
                painter = painterResource(
                    id = R.drawable.hotel_gallery_2
                ),
                contentDescription = "place_item_gallery",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .padding(10.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}
@Composable
@Preview
fun PreviewDetailScreen (){
    ComposeAcademyTheme {
        Surface{
            DetailScreen()
        }
    }
}