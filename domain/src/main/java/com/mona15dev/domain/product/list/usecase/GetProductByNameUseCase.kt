package com.mona15dev.domain.product.list.usecase

import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.domain.product.list.repository.ProductListRepository
import javax.inject.Inject

class GetProductByNameUseCase @Inject constructor(
    private val productRepository: ProductListRepository
) {
    suspend fun getProductsByName(searchByName: String): List<Product> =
        productRepository.getProductsByName(searchByName)
}