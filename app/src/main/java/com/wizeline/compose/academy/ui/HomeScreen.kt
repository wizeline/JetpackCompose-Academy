package com.wizeline.compose.academy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryGray
import com.wizeline.compose.academy.ui.theme.PrimaryGrayOpacity

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.label_explore),
                        style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = PrimaryGray
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.label_explore_description),
                        style = MaterialTheme.typography.body1.copy(
                            color = PrimaryGray
                        )
                    )
                }
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)
                )
            }

            CustomHeightSpacer()
            SearchBar()


            CustomHeightSpacer(SpacerHeight.LARGE)

            HorizontalTabList(
                list = listOf("Hotels","Things to do","Events","Sights")
            )

            CustomHeightSpacer(SpacerHeight.LARGE)

            LazyRow {
                items(3){
                    PlaceItemCard()
                }
            }

            CustomHeightSpacer(SpacerHeight.LARGE)


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Categories",
                    style = MaterialTheme.typography.h6.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "See more",
                    style = MaterialTheme.typography.body2.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.primary
                    )
                )
            }


            LazyRow {
                items(5) {
                    CategoryItemCard(
                        title = "Mountains",
                        image = painterResource(id = R.drawable.hotel_image)
                    )
                }
            }
        }

    }
}

@Composable
fun CategoryItemCard(
    title: String,
    image: Painter
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .background(Color.White)
            .padding(5.dp),
        elevation = 0.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = title)
        }
    }
}


@Composable
fun PlaceItemCard() {
    Card(
        modifier = Modifier.padding(5.dp),
        shape =  RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        Column {
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .width(250.dp)
                        .padding(5.dp)
                        .clip(
                            RoundedCornerShape(15.dp)
                        ),
                    contentScale = ContentScale.Crop
                )

                CircleButton(icon = Icons.Outlined.FavoriteBorder) {}

            }
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
            ) {
                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)
                Ranking()

                Text(
                    text = "Casa las Tortugas",
                    style = MaterialTheme.typography.h6.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)

                Row {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = null,
                        tint = PrimaryGrayOpacity
                    )
                    Text(
                        text = "Av Damero, Mexico",
                        style = MaterialTheme.typography.body1.copy(
                            color = PrimaryGrayOpacity
                        )
                    )
                }

                CustomHeightSpacer(SpacerHeight.EXTRA_SMALL)
                PlaceTextPrice()

            }
        }

    }
}

@Composable
fun PlaceTextPrice(
    modifier: Modifier = Modifier
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            ) {
                append("$1,260")
            }
            withStyle(
                style = SpanStyle(
                    color = PrimaryGrayOpacity
                )
            ) {
                append("/")
                append("night")
            }
        },
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CircleButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.padding(10.dp)) {
        Box(modifier = Modifier
            .background(
                color = Color.White,
                shape = CircleShape
            )
            .padding(5.dp)
        ){
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .clickable { onClick() },
                tint = PrimaryGray
            )
        }
    }
}



@Composable
fun Ranking(
    showLabel: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..5) {
            Icon(
                Icons.Default.Star,
                contentDescription = null,
                tint = Color(0XFFE0A534)
            )
        }
        Text(
            text = if (showLabel) "(347 reviews)" else "(347)",
            style = MaterialTheme.typography.body2.copy(
                color = PrimaryGrayOpacity
            )
        )
    }
}

@Composable
fun HorizontalTabList(
    list: List<String>,
    selectedIndex: Int = 0
) {
    LazyRow {
        itemsIndexed(list) { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item,
                    style = MaterialTheme.typography.body1.copy(
                        color = if(selectedIndex == index) MaterialTheme.colors.primary else PrimaryGray.copy(
                            alpha = 0.5f
                        ),
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 10.dp
                    )
                )
                if (selectedIndex == index) {
                    Box(
                        modifier = Modifier
                            .size(5.dp)
                            .background(
                                color = MaterialTheme.colors.primary,
                                shape = CircleShape
                            )
                    ){}
                }
            }
        }
    }
}


@Composable
fun SearchBar(
    elevation: Dp = 15.dp,
    shape: RoundedCornerShape = RoundedCornerShape(15.dp)
) {
    Card(
        shape = shape,
        elevation = elevation
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Search", color = PrimaryGray)
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                backgroundColor = Color.White
            ),
            shape = shape,
        )
    }
}

@Composable
@Preview
fun PreviewHomeScreen() {
    ComposeAcademyTheme {
        Surface {
            HomeScreen()
            //PlaceItemCard()
        }
    }
}
