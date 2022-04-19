package com.wizeline.compose.academy

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import com.wizeline.compose.academy.mock.MockData
import com.wizeline.compose.academy.models.FullModel
import com.wizeline.compose.academy.ui.screens.dashboard.DashboardScreen
import com.wizeline.compose.academy.ui.screens.detail.DetailScreen
import com.wizeline.compose.academy.ui.screens.gallery.ImageGalleryScreen
import com.wizeline.compose.academy.ui.screens.landing.LandingScreen
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
                    val model = Gson().fromJson(MockData.mockJson, FullModel::class.java)
                    LandingScreen()
                    //DashboardScreen(model)
                    //DetailScreen(model.places[0], click = {})
                    //ImageGalleryScreen(model.places[0].images)
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
private fun DefaultPreview() {
    ComposeAcademyTheme {
        Greeting("Android")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun DefaultDarkPreview() {
    ComposeAcademyTheme {
        Greeting(name = "Android")
    }
}
