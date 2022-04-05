package com.wizeline.compose.academy

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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wizeline.compose.academy.ui.*
import com.wizeline.compose.academy.ui.modifiers.defaultScreen
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGrayOpacity

@Composable
fun DetailScreen() {

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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_image_2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleButton(icon = Icons.Default.ArrowBack) {}
                    CircleButton(icon = Icons.Filled.FavoriteBorder) {}
                }
            }
        }

        DetailCardContent(
            modifier = Modifier
                .fillMaxWidth()
                .height(contentHeight.dp)
        )
    }
}


@Composable
fun DetailCardContent(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(
            topStart = 30.dp,
            topEnd = 30.dp
        ),
        elevation = 0.dp,
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.padding(20.dp)
        ) {

                  item {
                      CustomHeightSpacer()
                      Text(
                          text = "Casa Las tortugas",
                          style = MaterialTheme.typography.h5.copy(
                              fontWeight = FontWeight.Bold
                          )
                      )
                      CustomHeightSpacer()

                      Ranking(showLabel = true)

                      CustomHeightSpacer()

                      Row {
                          Icon(
                              Icons.Filled.LocationOn,
                              contentDescription = null,
                              tint = MaterialTheme.colors.primary
                          )
                          Text(
                              text = "Av Damero, 77310 Isla Holbox, Q.R, Mexico",
                              style = MaterialTheme.typography.body1.copy(
                                  color = PrimaryGrayOpacity
                              )
                          )
                      }

                      CustomHeightSpacer()

                      HorizontalTabList(
                          list = listOf("Overview","Details","Costs")
                      )
                      CustomHeightSpacer()

                      Text(
                          text = stringResource(id = R.string.label_place_description),
                          color = PrimaryGrayOpacity,
                      )
                      CustomHeightSpacer(SpacerHeight.SMALL)

                      Row {
                          Text(
                              text = "See more",
                              color = MaterialTheme.colors.primary
                          )
                          Icon(
                              Icons.Default.ArrowForward,
                              contentDescription = null,
                              tint = MaterialTheme.colors.primary
                          )
                      }

                      CustomHeightSpacer()
                      PlaceImageGallery()

                      Row(
                          modifier = Modifier.fillMaxWidth(),
                          verticalAlignment = Alignment.CenterVertically,
                          horizontalArrangement = Arrangement.SpaceBetween
                      ) {

                          PlaceTextPrice(
                              modifier = Modifier.padding(horizontal = 20.dp)
                          )
                          CustomButton(
                              title = "Check availability",
                          )
                      }
                  }
                }
    }
}

@Composable
fun PlaceImageGallery() {
    LazyRow {
        items(4) {
            Image(
                painter = painterResource(id = R.drawable.hotel_gallery),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))

            )
        }
    }
}


@Composable
@Preview
fun PreviewDetailScreen() {
    ComposeAcademyTheme {
        Surface {
            DetailScreen()
        }
    }
}
