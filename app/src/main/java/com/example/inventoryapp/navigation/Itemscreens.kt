package com.example.inventoryapp.navigation

enum class Itemscreens {
    HomeScreen,
    ListItemScreen,
    AddItemScreen,
    EditItemScreen;
    // can call if you don't want to instantiate an object
    companion object {
        fun fromRoute(route: String?): Itemscreens
        = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            ListItemScreen.name -> ListItemScreen
            AddItemScreen.name -> AddItemScreen
            EditItemScreen.name -> EditItemScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}