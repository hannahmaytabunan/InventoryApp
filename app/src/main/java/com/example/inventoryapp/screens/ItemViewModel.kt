package com.example.inventoryapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.inventoryapp.data.ItemsDatasource
import com.example.inventoryapp.models.Item

class ItemViewModel : ViewModel() {
    var itemList = mutableStateListOf<Item>()

    init {
        itemList.addAll(ItemsDatasource().loadItems())
    }

    fun addItem(item: Item) {
        itemList.add(item)
    }

    fun removeItem(item: Item) {
        itemList.remove(item)
    }

    fun getAllItems(): List<Item> {
        return itemList
    }
}