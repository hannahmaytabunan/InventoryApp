package com.example.inventoryapp.di

import android.content.Context
import androidx.room.Room
import com.example.inventoryapp.data.InventoryDatabase
import com.example.inventoryapp.data.InventoryDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideInventoryDao(inventoryDatabase: InventoryDatabase): InventoryDatabaseDao
    = inventoryDatabase.inventoryDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): InventoryDatabase
    = Room.databaseBuilder(
        context,
        InventoryDatabase::class.java,
        "items_db")
        .fallbackToDestructiveMigration()
        .build()
}