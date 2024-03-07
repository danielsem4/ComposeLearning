@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composelearning.Presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.composelearning.Data.Dimen.SmallPadding1

@Composable
fun CustomTextInput(
    textHint: String,
    icon: ImageVector,
    textState: MutableState<String>
) {
    OutlinedTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(text = textHint) },
        leadingIcon = { Icon(imageVector = icon, contentDescription = textHint) },
        modifier = Modifier.padding(SmallPadding1),
        textStyle = TextStyle(textAlign = TextAlign.Right),
    )
}