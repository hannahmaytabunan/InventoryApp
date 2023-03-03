package com.example.inventoryapp.repository

import com.example.inventoryapp.data.InventoryDatabaseDao
import com.example.inventoryapp.models.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class InventoryRepository @Inject constructor(private val inventoryDatabaseDao: InventoryDatabaseDao) {
    suspend fun addItem(item: Item) = inventoryDatabaseDao.insert(item)
    suspend fun updateItem(item: Item) = inventoryDatabaseDao.update(item)
    suspend fun deleteItem(item: Item) = inventoryDatabaseDao.delete(item)
    suspend fun deleteAllItems() = inventoryDatabaseDao.deleteAll()
    fun getAllItems(): Flow<List<Item>> = inventoryDatabaseDao.getItems().flowOn(Dispatchers.IO).conflate()
}