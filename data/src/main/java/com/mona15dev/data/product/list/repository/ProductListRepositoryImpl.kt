package com.mona15dev.data.product.list.repository

import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.domain.product.list.repository.ProductListRepository
import javax.inject.Inject

class ProductListRepositoryImpl @Inject constructor(
    private val remote: ProductListRetrofitRepository,
    private val local: ProductListRoomRepository
) : ProductListRepository {
    override suspend fun getProductsByName(search: String): List<Product> {
        try {
            //BD
            //return remote.getProductsByNameRetrofit(search)
            return listOf(
                Product("1", "Smartphone", 699.99, "https://example.com/thumbnail1.jpg"),
                Product("2", "Laptop", 1299.99, "https://example.com/thumbnail2.jpg"),
                Product("3", "Headphones", 149.99, "https://example.com/thumbnail3.jpg")
            )
        } catch  (cause: Throwable) {
            throw Exception("getProductsByName")
        }
    }
}