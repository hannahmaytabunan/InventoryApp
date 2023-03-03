package com.example.inventoryapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.inventoryapp.models.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase: RoomDatabase() {
    abstract fun itemDao(): InventoryDatabaseDao
}