package com.example.foodapp.activity.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.R

@Preview(showBackground = true)
@Composable
fun MyBottomBar() {

    val bottomMenuItemList = prepareBottomMenu()
    var selectedItem by remember { mutableStateOf("Home") }

    BottomAppBar(
        containerColor = colorResource(id = R.color.white)
    ) {

        bottomMenuItemList.forEach { bottomMenuItem ->

            NavigationBarItem(
                selected = selectedItem == bottomMenuItem.label,

                onClick = {
                    selectedItem = bottomMenuItem.label
                },

                icon = {
                    Icon(
                        painter = bottomMenuItem.icon,
                        contentDescription = bottomMenuItem.label,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .size(20.dp)
                    )
                }
            )
        }
    }
}

data class BottomMenuItem(
    val label: String,
    val icon: Painter
)

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> {

    return listOf(

        BottomMenuItem(
            label = "Home",
            icon = painterResource(id = R.drawable.btn_1)
        ),

        BottomMenuItem(
            label = "Cart",
            icon = painterResource(id = R.drawable.btn_2)
        ),

        BottomMenuItem(
            label = "Favorite",
            icon = painterResource(id = R.drawable.btn_3)
        ),

        BottomMenuItem(
            label = "Order",
            icon = painterResource(id = R.drawable.btn_4)
        ),

        BottomMenuItem(
            label = "Profile",
            icon = painterResource(id = R.drawable.btn_5)
        )
    )
}