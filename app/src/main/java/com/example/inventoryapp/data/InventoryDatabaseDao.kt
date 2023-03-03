package com.example.inventoryapp.data

import androidx.room.*
import com.example.inventoryapp.models.Item

@Dao
interface InventoryDatabaseDao {

    @Query("SELECT * from items_tbl")
    fun getItems(): List<Item>

    @Query("SELECT * from items_tbl where id = :id")
    suspend fun getItemById(id: String): Item

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: Item)

    @Query("DELETE from items_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(item: Item)
}
