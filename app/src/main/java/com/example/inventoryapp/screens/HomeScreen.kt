package com.example.inventoryapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inventoryapp.components.DrawerContent
import com.example.inventoryapp.components.ItemRow
import com.example.inventoryapp.data.ItemsDatasource
import com.example.inventoryapp.models.Item
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    list: List<Item>
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerContent(navController = navController)
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Ticket", color = Color.White)
                },
                actions = {
                    /*TODO: Add customer*/
                    //                Icon(imageVector = Icons.Rounded.List,
                    //                    contentDescription = "Nav Icon",
                    //                    tint = Color.White)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                scaffoldState.drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Rounded.List,
                                contentDescription = "Nav Icon",
                                tint = Color.White,
                            )
                        }
                    )
                },
                backgroundColor = Color(0xFF389738)
            )
        }
    ) {
        MainContent(
//            navController = navController,
            itemList = list
        )
    }
}
//@Preview(showBackground = true)
@Composable
fun MainContent(
//    navController: NavController,
    itemList: List<Item> = emptyList()
) {
//    val list = ItemsDatasource().loadItems()

    var charge by remember {
        mutableStateOf(0.0)
    }

    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        TopHeader(charge = charge)

        Surface(
            color = MaterialTheme.colors.background
        ) {
            LazyColumn {
                items(itemList) { item ->
                    ItemRow(item = item, onItemClicked = {
                        charge += item.price
                    })
                }
            }
        }
    }
}

@Composable
fun TopHeader(
    charge: Double
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 15.dp, start = 6.dp, end = 6.dp)
            .height(100.dp),
        color = MaterialTheme.colors.primaryVariant
    ) {
        Column(modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Charge",
                color = if (charge > 0.0) Color.White else Color.LightGray,
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "$charge",
                color = if (charge > 0.0) Color.White else Color.LightGray,
                style = MaterialTheme.typography.h5
            )
        }
    }
}