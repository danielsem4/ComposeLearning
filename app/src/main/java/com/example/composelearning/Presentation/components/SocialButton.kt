package com.example.composelearning.Presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.composelearning.Data.Dimen.SmallTextSize1

@Composable
fun SocialButton(
    platform: String,
    image: Painter,
    onSocialButton: () -> Unit,

) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = onSocialButton,
        ) {
            Image(
                modifier = Modifier,
                painter = image,
                contentDescription = platform
            )
        }
        Text(
            text = platform,
            style = TextStyle(
                fontSize = SmallTextSize1,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        )
    }

}