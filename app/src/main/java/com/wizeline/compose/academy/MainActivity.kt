package com.wizeline.compose.academy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
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
//                   // Greeting("Android")
//                 //   LandingScreen()
//                      HomeScreen()
//                 // DetailScreen()
//                   // ImageGalleryScreen()

                    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
                        AppNavigation()
                    }

                }
            }
        }
    }
}

val LocalNavController = compositionLocalOf<NavHostController> {
    error("composition not found")
}

@Composable
fun AppNavigation(

) {
    val navController = LocalNavController.current
    NavHost(navController = navController, startDestination = "landing"){
        composable(
            route = "landing"
        ) {
            LandingScreen()
        }
        composable(
            route = "home"
        ) {
            HomeScreen()
        }
        composable(
            route = "detail"
        ) {
            DetailScreen()
        }
        composable(
            route = "gallery"
        ) {
            ImageGalleryScreen()
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
        Greeting("Android")
    }
}
