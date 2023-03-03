package com.example.inventoryapp.screens.items

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.inventoryapp.components.ItemRow
import com.example.inventoryapp.data.ItemsDatasource
import com.example.inventoryapp.models.Item
import com.example.inventoryapp.navigation.Itemscreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListItemScreen(
    navController: NavController,
    list: List<Item>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Items", color = Color.White)
                },
                navigationIcon = {
                    Icon(imageVector = Icons.Rounded.List,
                        contentDescription = "Nav Icon",
                        tint = Color.White)
                },
                backgroundColor = Color(0xFF2c2b3d)
            )
        } , floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape, onClick = {
                    navController.navigate(
                        route = Itemscreens.AddItemScreen.name
                    )
                },
                backgroundColor = Color(0xFF2c2b3d),
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add Icon",
                )
            }
        }
    ) {
        LazyColumn {
            items(list) { item ->
                ItemRow(item = item, onItemClicked = {})
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ItemListScreenPreview() {
//    ListItemScreen(
//        list = ItemsDatasource().loadItems()
//    )
//}