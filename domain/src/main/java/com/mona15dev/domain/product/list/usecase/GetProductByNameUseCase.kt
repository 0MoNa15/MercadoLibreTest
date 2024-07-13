package com.mona15dev.domain.product.list.usecase

import com.mona15dev.domain.product.list.model.Product
import javax.inject.Inject

class GetProductByNameUseCase @Inject constructor(
    //private val productRepository: ProductListRepository
) {
    suspend fun getProductsByName(searchByName: String) : List<Product> =
        listOf(
            Product("1", "Smartphone", 699.99, "https://example.com/thumbnail1.jpg"),
            Product("2", "Laptop", 1299.99, "https://example.com/thumbnail2.jpg"),
            Product("3", "Headphones", 149.99, "https://example.com/thumbnail3.jpg")
        )
        //productRepository.getProductsByName(searchByName)
}