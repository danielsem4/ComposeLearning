package com.example.composelearning.Data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerItem(
    val title: String,
    val icon: ImageVector,
    val contentDescription: String,
    val id: String,
)

// list of the items in the navigation drawer
val items = listOf(
    DrawerItem(
        title = "Home",
        icon = Icons.Filled.Home,
        contentDescription = "Home",
        id = "home"
    ),
    DrawerItem(
        title = "Cart",
        icon = Icons.Filled.ShoppingCart,
        contentDescription = "Cart",
        id = "cart"
    ),
    DrawerItem(
        title = "Help",
        icon = Icons.Filled.Info,
        contentDescription = "Help",
        id = "help"
    ),
    DrawerItem(
        title = "Settings",
        icon = Icons.Filled.Settings,
        contentDescription = "Settings",
        id = "settings"
    ),
)
