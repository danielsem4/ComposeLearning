@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composelearning.Presentation.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import com.example.composelearning.Data.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import com.example.composelearning.Data.Dimen.SmallPadding1
import com.example.composelearning.Data.DrawerItem


@Composable
fun NavigationDrawer(
    modifier: Modifier = Modifier,
    onItemClick: (DrawerItem) -> Unit
) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    ModalDrawerSheet {
        items.forEachIndexed { index, item ->
            NavigationDrawerItem(
                label = {
                    Text(text = item.title)
                },
                icon = {
                       Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                },
                selected = index == selectedItemIndex,
                onClick = {
                    selectedItemIndex = index
                    onItemClick(item)
                },
                modifier = Modifier
                    .padding(SmallPadding1)
            )
        }
    }
}