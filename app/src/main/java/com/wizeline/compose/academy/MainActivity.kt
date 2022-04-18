package com.wizeline.compose.academy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.wizeline.compose.academy.ui.screens.DetailScreen
import com.wizeline.compose.academy.ui.screens.HomeScreen
import com.wizeline.compose.academy.ui.screens.LandingScreen
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
          // HomeScreen()
          // DetailScreen()
          // LandingScreen()
          // ImageGalleryScreen()
        }
      }
    }
  }
}
