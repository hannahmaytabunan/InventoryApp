package com.example.inventoryapp.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventoryapp.data.ItemsDatasource
import com.example.inventoryapp.models.Item
import com.example.inventoryapp.repository.InventoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repository: InventoryRepository) : ViewModel() {
//    var itemList = mutableStateListOf<Item>()

    private val _itemList = MutableStateFlow<List<Item>>(emptyList())
    val itemList = _itemList.asStateFlow()

    init {
//        itemList.addAll(ItemsDatasource().loadItems())
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllItems().distinctUntilChanged().collect { listOfItems ->
                if (listOfItems.isNullOrEmpty()) {
                    Log.d("Empty", ": Empty list")
                } else {
                    _itemList.value = listOfItems
                }
            }
        }
    }

    fun getItem(id: String) = viewModelScope.launch { repository.getItem(id) }

    fun addItem(item: Item) = viewModelScope.launch { repository.addItem(item) }

    fun updateItem(item: Item) = viewModelScope.launch { repository.updateItem(item) }

    fun removeItem(item: Item) = viewModelScope.launch { repository.deleteItem(item) }
}