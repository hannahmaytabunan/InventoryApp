package com.example.inventoryapp.data

import com.example.inventoryapp.models.Item

class ItemsDatasource {
    fun loadItems(): List<Item> {
        return listOf(
            Item(name = "Soup - Campbells - Chicken Noodle", price = 55.66, stock = 47),
            Item(name = "Tomatoes Tear Drop", price = 47.11, stock = 34),
            Item(name = "Wine - Magnotta - Bel Paese White", price = 93.04, stock = 36),
            Item(name = "Ginger - Ground", price = 59.63, stock = 67),
            Item(name = "Tomatoes - Roma", price = 7.5, stock = 82),
            Item(name = "Fib N9 - Prague Powder", price = 29.45, stock = 28),
            Item(name = "Broom And Brush Rack Black", price = 3.8, stock = 89),
            Item(name = "Yeast Dry - Fermipan", price = 18.69, stock = 8),
            Item(name = "Bagel - Everything", price = 53.08, stock = 11),
            Item(name = "Kiwi Gold Zespri", price = 72.93, stock = 5)
        )
    }
}