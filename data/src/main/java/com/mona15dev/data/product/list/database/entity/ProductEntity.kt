package com.mona15dev.data.product.list.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mona15dev.domain.product.list.model.Product

@Entity
data class ProductEntity (
    @PrimaryKey
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String,
    val condition: String
)

fun ProductEntity.mapperToModel() = Product(
    id = id,
    title = title,
    price = price,
    thumbnail = thumbnail,
    condition = condition
)

fun Product.mapperToEntity() = ProductEntity(
    id = id,
    title = title,
    price = price,
    thumbnail = thumbnail,
    condition = condition
)