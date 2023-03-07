package com.example.inventoryapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inventoryapp.navigation.Itemscreens

@Composable
fun DrawerContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(start = 24.dp, top = 48.dp, bottom = 48.dp)) {
                Text("Owner",
//                modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.h5)
                Text("POS 1",
//                modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.caption
                )
                Text("EN-ventory System",
//                modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.caption
                )
            }
        }
        Divider()
        Spacer(Modifier.height(6.dp))
        Column(modifier = Modifier.padding(start = 24.dp, top = 48.dp)) {
            IconButton(onClick = {
                navController.navigate(
                    route = Itemscreens.HomeScreen.name
                )
            }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Shopping Cart Icon",
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Sales")
                }
            }

            IconButton(onClick = {
                navController.navigate(
                    route = Itemscreens.ListItemScreen.name
                )
            }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.List,
                        contentDescription = "Item Icon",
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Items")
                }
            }
        }
    }
}