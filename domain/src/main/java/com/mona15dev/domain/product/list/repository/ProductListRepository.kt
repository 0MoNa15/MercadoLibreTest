package com.mona15dev.domain.product.list.repository

import com.mona15dev.domain.product.list.model.Product

interface ProductListRepository {
    suspend fun getProductsByName(search: String): List<Product>
}