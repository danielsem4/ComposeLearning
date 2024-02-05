@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composelearning.presentation.components
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit,
    imageVector: ImageVector?
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(
                onClick = onNavigationIconClick
            ) {
                imageVector?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = "Passed icon"
                    )
                }
            }
        },
        title = {
            Text(text = "Paws & Claws")
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            MaterialTheme.colorScheme.surfaceColorAtElevation(
                3.dp
            )
        ),
    )
}