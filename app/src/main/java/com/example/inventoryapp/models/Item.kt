package com.example.inventoryapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "items_tbl")
data class Item(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "item_name")
    val name: String,

    @ColumnInfo(name = "item_price")
    val price: Double,

    @ColumnInfo(name = "item_stock")
    val stock: Int,

    @ColumnInfo(name = "item_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)
