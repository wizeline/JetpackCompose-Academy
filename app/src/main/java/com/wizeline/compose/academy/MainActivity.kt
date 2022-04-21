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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.domain.getFormatMoney
import com.wizeline.compose.academy.domain.models.PlaceModel
import com.wizeline.compose.academy.ui.details.DetailsPage
import com.wizeline.compose.academy.ui.home.HomePage
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
    val currentScreen = ComposeAcademyScreen.fromRoute(backstackEntry.value?.destination?.route)
    ComposeAcademyTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            DetailsPage(PlaceModel("Test","address",100.00.getFormatMoney(),"night",234,4.3))
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
            DetailsPage(PlaceModel("Test","address",100.00.getFormatMoney(),"night",234,4.3))
        }
    }
}
