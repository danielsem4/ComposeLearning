@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composelearning.Presentation.navgraph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composelearning.Presentation.contactUs.ContactUs
import com.example.composelearning.Presentation.home.HomePage

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.HomeScreen.route) {
        composable(route = Route.HomeScreen.route) {
            HomePage(modifier = Modifier, navController = navController)
        }
        composable(route = Route.ContactUs.route) {
            ContactUs(navController = navController)
        }
    }
}