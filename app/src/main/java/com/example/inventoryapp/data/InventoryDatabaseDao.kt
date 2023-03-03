package com.example.inventoryapp.data

import androidx.room.*
import com.example.inventoryapp.models.Item

@Dao
interface InventoryDatabaseDao {

    @Query("SELECT * from items_tbl")
    fun getItems(): List<Item>

    @Query("SELECT * from items_tbl where id = :id")
    fun getItemById(id: String): Item

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Item)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(item: Item)

    @Query("DELETE from items_tbl")
    fun deleteAll()

    @Delete
    fun delete(item: Item)
}
