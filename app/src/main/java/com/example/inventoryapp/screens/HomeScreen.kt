package com.example.inventoryapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.inventoryapp.navigation.Itemscreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
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
    }, floatingActionButton = {
        FloatingActionButton(shape = CircleShape, onClick = {
            navController.navigate(route = Itemscreens.AddItemScreen.name)
        },
            backgroundColor = Color(0xFF2c2b3d),
            contentColor = Color.White
            ) {
            Icon(imageVector = Icons.Rounded.Add,
                contentDescription = "Add Icon",)
        }
    }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController
//    movieList: List<Movie> = getMovies(),
//    itemList: List<Item> = getItems()
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
//        LazyColumn {
//            items(items = movieList) {
//                MovieRow(movie = it) { movie ->
//                    navController.navigate(route = Moviescreens.DetailsScreen.name+"/$movie")
////                    Log.d("TAG", "MainContent: $movie")
//                }
//            }
//        }
//        LazyColumn {
//            items(items = itemList) {
//                ItemRow(item = it) { item ->
//                    navController.navigate(route = Itemscreens.DetailsScreen.name+"/$item")
////                    Log.d("TAG", "MainContent: $movie")
//                }
//            }
//        }
        Text(text  = "Hello World")

    }
}