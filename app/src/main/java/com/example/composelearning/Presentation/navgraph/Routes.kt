package com.example.composelearning.Presentation.navgraph

sealed class Route (
    val route: String
){
    object HomeScreen: Route(route = "homeScreen")
    object ContactUs: Route(route = "contactUs")

}