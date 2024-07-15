package com.mona15dev.data.product.list.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mona15dev.data.product.list.database.dao.ProductDao
import com.mona15dev.data.product.list.database.entity.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun upcomingProductListDao(): ProductDao
}