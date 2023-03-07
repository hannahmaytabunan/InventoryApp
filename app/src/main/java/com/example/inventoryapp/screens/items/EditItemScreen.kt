package com.example.inventoryapp.screens.items

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.disabled
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inventoryapp.components.ItemButton
import com.example.inventoryapp.components.ItemInputNumber
import com.example.inventoryapp.components.ItemInputText
import com.example.inventoryapp.models.Item
import com.example.inventoryapp.navigation.Itemscreens
import com.example.inventoryapp.util.UUIDConverter
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditItemScreen(
    navController: NavController,
    itemList: List<Item>,
    itemID: String,
    onUpdateItem: (Item) -> Unit,
    onRemoveItem: (Item) -> Unit
) {
    val fetchItem = itemList.filter { item ->
        item.id == UUIDConverter().uuidFromString(itemID)
    }

    val item = fetchItem.first()

    var name by remember {
        mutableStateOf(item.name)
    }
    var price by remember {
        mutableStateOf(item.price)
    }
    var stock by remember {
        mutableStateOf(item.stock)
    }
    val context = LocalContext.current

    var showDeleteConfirmation by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Edit Item", color = Color.White)
            },
            navigationIcon = {
                Icon(imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Arrow Back Icon",
                    tint = Color.White,
                    modifier = Modifier.clickable { navController.popBackStack() }
                )
            },
            actions = {
                ItemButton(
                    text = "SAVE",
                    onClick = {
                        if (name.isNotEmpty()) {
                            onUpdateItem(
                                Item(
                                    id = item.id,
                                    name = name,
                                    price = price,
                                    stock = stock
                                )
                            )
                            name = ""
                            price = 0.0
                            stock = 0
                            Toast.makeText(context, "Item updated", Toast.LENGTH_SHORT).show()
                            navController.navigate(
                                route = Itemscreens.ListItemScreen.name
                            )
                        }
                    },
                    backgroundColor = Color.Transparent,
                    contentColor = Color.White,
                    elevation = null
                )
            },
            backgroundColor = MaterialTheme.colors.primaryVariant
        )
    }, backgroundColor = Color.LightGray) {
        Column {
            Surface(modifier = Modifier.padding(bottom = 10.dp), elevation = 5.dp) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    ItemInputText(
                        text = name,
                        label = "Name",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) name = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 9.dp, bottom = 8.dp)
                    )
                    ItemInputNumber(
                        text = "$price",
                        label = "Price",
                        onTextChange = {
                            if (it.isNotEmpty()) price = it.toDouble()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 9.dp, bottom = 8.dp)
                    )
                }
            }


            Surface(modifier = Modifier.padding(vertical = 10.dp), elevation = 5.dp) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Inventory",
                        color = Color(0xFF2c2b3d),
                        style = MaterialTheme.typography.h6
                    )
                    ItemInputNumber(
                        text = "$stock",
                        label = "Stock",
                        onTextChange = {
                            if (it.isNotEmpty()) stock = it.toInt()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 9.dp, bottom = 8.dp)
                    )
                }
            }
//            }

            Surface(modifier = Modifier.padding(vertical = 10.dp)) {
                Button( onClick = {
                    showDeleteConfirmation = true
                }, modifier = Modifier.fillMaxWidth(),
                    elevation = null,
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.Transparent,
                    )
                ) {
                    Icon(imageVector = Icons.Default.Delete,
                        contentDescription = "Delete Icon",
                        tint = Color.DarkGray,
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                    Text(
                        text = "DELETE ITEM",
                        color = Color.Black
                    )
                }
            }
        }
    }

    if (showDeleteConfirmation) {
        AlertDialog(
            onDismissRequest = {
                showDeleteConfirmation = false
            },
            title = {
                Text(text = "Delete Item", style = MaterialTheme.typography.h5)
            },
            text = {
               Text(text = "Are you sure you want to delete the item?")
            },
            confirmButton = {
                TextButton(onClick = {
                    onRemoveItem(item)
                    Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                    showDeleteConfirmation = false
                }) {
                    Text(text = "Delete")
                }
            },
            modifier = Modifier.padding(10.dp),
            dismissButton = {
                TextButton(onClick = {
                    showDeleteConfirmation = false
                }) {
                    Text(text = "Cancel")
                }
            },
        )
    }
}