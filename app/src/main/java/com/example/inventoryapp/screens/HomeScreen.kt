package com.example.inventoryapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inventoryapp.components.DrawerContent
import com.example.inventoryapp.models.Item
import com.example.inventoryapp.navigation.Itemscreens
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
                backgroundColor = Color(0xFF2c2b3d)
            )
        }
    ) {
        MainContent(
            navController = navController,
            itemList = list
        )
    }
}

@Composable
fun MainContent(
    navController: NavController,
    itemList: List<Item>
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Text(text  = "Hello World")
    }
}

//@Preview(showBackground = true)
