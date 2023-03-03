package com.example.inventoryapp.models

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class Item(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val price: Double,
    val stock: Int,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
