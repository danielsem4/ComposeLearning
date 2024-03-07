package com.example.composelearning.Presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composelearning.Data.Dimen

@Composable
fun HomePageButton(
    buttonText: String,
    icon: ImageVector,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedButton(
        onClick = onButtonClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = buttonText
        )
        Spacer(modifier = modifier.width(Dimen.SmallPadding1))
        Text(text = buttonText)
    }
}