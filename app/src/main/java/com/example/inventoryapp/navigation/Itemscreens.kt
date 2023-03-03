package com.example.inventoryapp.navigation

enum class Itemscreens {
    ListItemScreen,
    AddItemScreen,
    EditItemScreen;
    // can call if you don't want to instantiate an object
    companion object {
        fun fromRoute(route: String?): Itemscreens
        = when (route?.substringBefore("/")) {
            ListItemScreen.name -> ListItemScreen
            AddItemScreen.name -> AddItemScreen
            EditItemScreen.name -> EditItemScreen
            null -> ListItemScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}