@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.composelearning.Presentation.navgraph.NavGraph
import com.example.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // splash screen
        installSplashScreen()
        setContent {
            ComposeLearningTheme {
                NavGraph()
            }
        }
    }
}

