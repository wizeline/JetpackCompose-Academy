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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wizeline.compose.academy.domain.getFormatMoney
import com.wizeline.compose.academy.domain.models.PlaceModel
import com.wizeline.compose.academy.ui.details.DetailsPage
import com.wizeline.compose.academy.ui.home.HomePage
import com.wizeline.compose.academy.ui.landing.LandingPage
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAcademyApp()
        }
    }
}

@Composable
fun ComposeAcademyApp() {
    val navController = rememberNavController()
    val backstackEntry = navController.currentBackStackEntryAsState()
    var currentScreen = ComposeAcademyScreen.fromRoute(backstackEntry.value?.destination?.route)
    ComposeAcademyTheme {
        // A surface container using the 'background' color from the theme
        val allScreens = ComposeAcademyScreen.values().toList()
        val navController = rememberNavController()
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            NavHost(
                navController = navController,
                startDestination = ComposeAcademyScreen.Landing.name
            ) {
                composable(ComposeAcademyScreen.Landing.name) {
                    LandingPage {
                        navController.navigate(ComposeAcademyScreen.Home.name)
                    }
                }
                composable(ComposeAcademyScreen.Home.name) {
                    HomePage {
                        navController.navigate("${ComposeAcademyScreen.Detail.name}/${it}")
                    }
                }
                composable(
                    route = "${ComposeAcademyScreen.Detail.name}/{place}",
                    arguments = listOf(
                        navArgument("place"){
                            type = NavType.StringType
                        }
                    )
                ) { entry ->
                    val place = entry.arguments?.getString("place") ?: ""
                    // Find first name match in UserData
                    DetailsPage(
                        place
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAcademyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            DetailsPage("Casa Las Tortugas")
        }
    }
}
