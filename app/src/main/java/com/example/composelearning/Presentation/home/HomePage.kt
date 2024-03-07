@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.composelearning.Presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.composelearning.Data.Dimen.MediumPadding1
import com.example.composelearning.Data.Dimen.MediumTextSize1
import com.example.composelearning.Data.Dimen.SmallPadding1
import com.example.composelearning.Data.images
import com.example.composelearning.R
import com.example.composelearning.Presentation.components.AppBar
import com.example.composelearning.Presentation.components.HomePageButton
import com.example.composelearning.Presentation.components.ImageSlider
import com.example.composelearning.Presentation.components.NavigationDrawer
import com.example.composelearning.Presentation.navgraph.Route
import kotlinx.coroutines.launch

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val scaffoldState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            NavigationDrawer(
                modifier = Modifier,
                onItemClick = {
                    scope.launch {
                        scaffoldState.close()
                    }
                }
            )
        },
        drawerState = scaffoldState
    ) {
        Scaffold(
            topBar = {
                AppBar(
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.open()
                        }
                    },
                    stringResource(id = R.string.shop_name),
                    Icons.Default.Menu
                )
            },
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(it))  // Spacer for the AppBar
                ImageSlider(modifier, images)  // ImageSlider
                Text(
                    text = stringResource(id = R.string.store_description),
                    style = TextStyle(
                        fontSize = MediumTextSize1,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = modifier.padding(SmallPadding1)
                )
                Spacer(modifier = modifier.height(MediumPadding1))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    HomePageButton(stringResource(id = R.string.store), Icons.Outlined.ShoppingCart, {})
                    HomePageButton(stringResource(id = R.string.contact), Icons.Outlined.Create, {
                        navController.navigate(Route.ContactUs.route)
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {

}
