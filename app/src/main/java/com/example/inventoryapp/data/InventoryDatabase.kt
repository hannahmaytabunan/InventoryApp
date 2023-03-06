package com.example.inventoryapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.inventoryapp.models.Item
import com.example.inventoryapp.util.DateConverter
import com.example.inventoryapp.util.UUIDConverter

@Database(entities = [Item::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class InventoryDatabase: RoomDatabase() {
    abstract fun inventoryDao(): InventoryDatabaseDao
}