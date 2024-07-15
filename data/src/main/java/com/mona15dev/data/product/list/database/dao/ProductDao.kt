package com.mona15dev.data.product.list.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mona15dev.data.product.list.database.entity.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUpcomingProductList(list: List<ProductEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(movie: ProductEntity)

    @Query("SELECT * FROM ProductEntity")
    suspend fun getAllProductList() : List<ProductEntity>

    @Query("SELECT * FROM ProductEntity WHERE title LIKE :search")
    suspend fun getProductListByName(search: String): List<ProductEntity>

    @Query("SELECT * FROM ProductEntity WHERE id = :id")
    suspend fun getProductDetail(id: Int) : ProductEntity
}