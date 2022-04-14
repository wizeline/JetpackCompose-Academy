package com.wizeline.compose.academy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.data.model.Hotel
import com.wizeline.compose.academy.ui.detail.DetailScreen
import com.wizeline.compose.academy.ui.gallery.ImageGalleryScreen
import com.wizeline.compose.academy.ui.home.HomeScreen
import com.wizeline.compose.academy.ui.landing.LandingScreen
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAcademyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LandingScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAcademyTheme {
        //HomeScreen()
        /*val hotel = Hotel(
            name = stringResource(id = R.string.hotel_name_sample_2),
            address = stringResource(id = R.string.addres_sample_2),
            stars = 3,
            price = 1620,
            reviews = 700,
            image = R.drawable.hotel_image_2,
            description = stringResource(id = R.string.label_place_description)
        )
        DetailScreen(hotel)
         */
        LandingScreen()
        //ImageGalleryScreen()
    }
}
