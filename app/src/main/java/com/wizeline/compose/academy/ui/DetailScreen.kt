package com.wizeline.compose.academy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.common.CircleIconButton
import com.wizeline.compose.academy.ui.common.Ranking
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun DetailScreen() {
    val configuration = LocalConfiguration.current
    val imageHeight by remember {
        mutableStateOf(configuration.screenHeightDp * 0.4)
    }
    val cardHeight by remember {
        mutableStateOf(configuration.screenHeightDp * 0.63)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.hotel_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                CircleIconButton(icon = Icons.Filled.ArrowBack)
                CircleIconButton(icon = Icons.Filled.FavoriteBorder)
            }
        }
       DetailCardContent(
           modifier = Modifier
               .fillMaxWidth()
               .height(cardHeight.dp)
       )
    }

}

@Composable
fun DetailCardContent(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            item {
                Text(
                    text = "Casa Las Tortugas",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Ranking()
                    Text(
                        text = "(347 reviews)",
                        style = MaterialTheme.typography.caption.copy(
                            color = Color.Gray.copy(
                                alpha = 0.6f
                            )
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                    Text(
                        text = "Av Damero, Mexico",
                        color = Color.Gray.copy(
                            alpha = 0.6f,
                        ),
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    CategoryItemTab(isSelected = true)
                    CategoryItemTab(isSelected = false)
                    CategoryItemTab(isSelected = false)
                }

                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ",
                    color = Color.Gray.copy(
                        alpha = 0.6f
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "See more >",
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.height(15.dp))
                LazyRow {
                    items(5){
                        Image(
                            painter = painterResource(id = R.drawable.hotel_image_2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(170.dp)
                                .padding(10.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.primary,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("$1260")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Gray.copy(
                                        alpha = 0.6f
                                    ),
                                    fontSize = 12.sp
                                )
                            )  {
                                append("/night")
                            }
                        },
                    )
                    CustomButton(text = "Check availability")
                }
            }
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
