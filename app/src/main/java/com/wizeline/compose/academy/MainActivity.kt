package com.wizeline.compose.academy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wizeline.compose.academy.presentation.ui.screens.detail.DetailScreen
import com.wizeline.compose.academy.presentation.ui.screens.home.HomeScreen
import com.wizeline.compose.academy.presentation.ui.screens.gallery.ImageGalleryScreen
import com.wizeline.compose.academy.presentation.ui.screens.landing.LandingScreen
import com.wizeline.compose.academy.presentation.ui.screens.util.Screen
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAcademyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background

                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController,
                            startDestination = Screen.LandingScreen.route)
                    {
                        composable(
                            route = Screen.LandingScreen.route
                        ){
                            LandingScreen(navController)
                        }
                        composable(
                            route = Screen.HomeScreen.route
                        ){
                            HomeScreen(navController)
                        }
                        composable(
                            route = Screen.DetailScreen.route + "?id={id}",
                            arguments = listOf(
                                navArgument("id")
                                {
                                    type= NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ){
                            val id = it.arguments?.getInt("id") ?: 0
                            DetailScreen(id= id, navController)
                        }
                        composable(
                            route = Screen.GalleryScreen.route + "?id={id}",
                            arguments = listOf(
                                navArgument("id")
                                {
                                    type= NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ){
                            val id = it.arguments?.getInt("id") ?: 0
                            ImageGalleryScreen(id= id)
                        }
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

    }
}
