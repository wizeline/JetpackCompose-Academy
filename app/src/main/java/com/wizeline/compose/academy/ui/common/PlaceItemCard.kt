package com.wizeline.compose.academy.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun PlaceItemCard(
) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp * 0.65
    val height = width + 10
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Column {
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .width(width.dp)
                        .height(200.dp)

                )
                CircleIconButton(
                    icon = Icons.Filled.FavoriteBorder
                )
            }
            PlaceInfoItemCard()
        }
    }
}

@Composable
fun CircleIconButton(
    icon: ImageVector
) {
    Box(
        modifier = Modifier.padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier.padding(10.dp),

                )
        }
    }
}

@Composable
private fun PlaceInfoItemCard() {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 15.dp)
    ) {
        Spacer(modifier = Modifier.height(3.dp))
        Row {
            Ranking()
            Text(
                text = "(347)",
                style = MaterialTheme.typography.overline,
                color = Color.Gray.copy(
                    alpha = 0.6f
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Casa las tortugas",
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Icon(
                Icons.Default.LocationOn,
                contentDescription = null,
                tint = Color.Gray.copy(
                    alpha = 0.6f
                )
            )
            Text(
                text = "Av Damero, Mexico",
                color = Color.Gray.copy(
                    alpha = 0.6f
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
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
            }
        )
    }
}

@Composable
fun Ranking() {
    Row {
        Icon(
            Icons.Default.Star,
            contentDescription = null,
            tint = Color(0XFFdfa431),
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(3.dp))
        Icon(
            Icons.Default.Star,
            contentDescription = null,
            tint = Color(0XFFdfa431),
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(3.dp))
        Icon(
            Icons.Default.Star,
            contentDescription = null,
            tint = Color(0XFFdfa431),
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(3.dp))
    }
}



@Composable
@Preview
fun PreviewPlaceItemCard() {
    ComposeAcademyTheme {
        Surface {
            PlaceItemCard()
        }
    }
}

