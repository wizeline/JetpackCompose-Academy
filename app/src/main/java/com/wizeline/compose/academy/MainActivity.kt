package com.wizeline.compose.academy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.data.dummy.hotelList
import com.wizeline.compose.academy.ui.DetailScreen
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import kotlin.random.Random

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
                    val screenToDisplay: Int = Random.nextInt(1, 6)
                    when (screenToDisplay) {
                        1 -> LandingScreen()
                        2 -> ExploreScreen()
                        3 -> DetailScreen(hotelList[0])
                        4 -> DetailScreen(hotelList[1])
                        5 -> DetailScreen(hotelList[2])
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAcademyTheme {
        LandingScreen()
    }
}
