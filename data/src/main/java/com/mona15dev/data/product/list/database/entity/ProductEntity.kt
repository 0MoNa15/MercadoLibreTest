package com.mona15dev.data.product.list.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity (
    @PrimaryKey
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String,
    val condition: String
)