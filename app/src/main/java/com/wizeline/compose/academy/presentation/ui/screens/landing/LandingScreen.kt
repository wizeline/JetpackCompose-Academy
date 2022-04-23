package com.wizeline.compose.academy.presentation.ui.screens.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.presentation.ui.components.buttons.CustomButton
import com.wizeline.compose.academy.presentation.ui.components.spacer.CustomHeightSpacer
import com.wizeline.compose.academy.presentation.ui.extensions.defaultScreen
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun LandingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.landing),
            contentDescription = stringResource(id = R.string.label_landing),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

       Column(
           modifier= Modifier
               .fillMaxSize()
               .padding(20.dp),
           verticalArrangement = Arrangement.Bottom
       ) {
           Text(text= stringResource(id = R.string.label_explore_places),
               style= MaterialTheme.typography.h4.copy(
                   color= Color.White,
                   fontWeight = FontWeight.Bold
               )
           )

           CustomHeightSpacer()

           Text(text= stringResource(id = R.string.label_explore_places_description),
               style= MaterialTheme.typography.body1.copy(
                   color= Color.White
               )
           )

           CustomHeightSpacer()

           CustomButton(title= stringResource(id = R.string.label_sign_in),
                        modifier = Modifier.fillMaxWidth(),
                        navController = navController)

           CustomHeightSpacer()

           Text(text= stringResource(id = R.string.label_create_account),
               color= Color.White,
               textDecoration = TextDecoration.Underline,
               textAlign = TextAlign.Center,
               modifier = Modifier.fillMaxWidth())
       }
    }
}

@Preview
@Composable
fun PreviewLandingScreen(){
    ComposeAcademyTheme() {
        Surface {
            LandingScreen(navController = rememberNavController())
        }
    }
}