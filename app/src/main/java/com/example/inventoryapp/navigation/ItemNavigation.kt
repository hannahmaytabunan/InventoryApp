package com.example.inventoryapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.inventoryapp.models.Item
import com.example.inventoryapp.screens.ItemViewModel
import com.example.inventoryapp.screens.items.AddItemScreen
import com.example.inventoryapp.screens.items.EditItemScreen
import com.example.inventoryapp.screens.items.ListItemScreen

@Composable
fun ItemNavigation(
    itemViewModel: ItemViewModel = viewModel()
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Itemscreens.ListItemScreen.name
    ) {
        val itemList = itemViewModel.getAllItems()

        composable(Itemscreens.ListItemScreen.name) {
             // here we pass where this should lead us to
            ListItemScreen(
                navController = navController,
                list = itemList
            )
        }

        composable(Itemscreens.AddItemScreen.name) {
            // here we pass where this should lead us to
            AddItemScreen(
                navController = navController,
                onAddItem = {
                    itemViewModel.addItem(it)
                }
            )
        }

//        www.google.com/details-screen/id=34
//        composable(
//            Itemscreens.EditItemScreen.name+"/{item}",
//            arguments = listOf(navArgument(name = "item") { type = NavType.StringType })
//        ) {
//            backStackEntry ->
//
//            // here we pass where this should lead us to
//            EditItemScreen(navController = navController, backStackEntry.arguments?.getString("item"))
//        }
    }
}
