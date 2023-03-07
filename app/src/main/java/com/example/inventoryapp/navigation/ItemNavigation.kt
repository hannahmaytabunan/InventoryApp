package com.example.inventoryapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.inventoryapp.models.Item
import com.example.inventoryapp.screens.HomeScreen
import com.example.inventoryapp.screens.ItemViewModel
import com.example.inventoryapp.screens.items.AddItemScreen
import com.example.inventoryapp.screens.items.EditItemScreen
import com.example.inventoryapp.screens.items.ListItemScreen

@Composable
fun ItemNavigation(
    items: List<Item>,
    onAddItem: (Item) -> Unit,
    onUpdateItem: (Item) -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Itemscreens.HomeScreen.name
    ) {
//        val itemList = itemViewModel.itemList.collectAsState().value

        composable(Itemscreens.HomeScreen.name) {
            // here we pass where this should lead us to
            HomeScreen(
                navController = navController,
                list = items
            )
        }

        composable(Itemscreens.ListItemScreen.name) {
            // here we pass where this should lead us to
            ListItemScreen(
                navController = navController,
                list = items
            )
        }

        composable(Itemscreens.ListItemScreen.name) {
             // here we pass where this should lead us to
            ListItemScreen(
                navController = navController,
                list = items
            )
        }

        composable(Itemscreens.AddItemScreen.name) {
            // here we pass where this should lead us to
            AddItemScreen(
                navController = navController,
                onAddItem = {
                    onAddItem(it)
                }
            )
        }

//        www.google.com/details-screen/id=34
        composable(
            Itemscreens.EditItemScreen.name+"/{itemID}",
            arguments = listOf(navArgument(name = "itemID") { type = NavType.StringType })
        ) {
            backStackEntry ->

            // here we pass where this should lead us to
            backStackEntry.arguments?.getString("itemID")?.let {
                EditItemScreen(
                    navController = navController,
                    it,
                    onUpdateItem = onUpdateItem
                )
            }
        }
    }
}
