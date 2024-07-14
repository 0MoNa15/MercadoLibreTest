package com.mona15dev.domain.product.detail.usecase

import com.mona15dev.domain.product.detail.model.ProductDetail
import com.mona15dev.domain.product.detail.repository.ProductDetailRepository
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    private val productDetailRepository: ProductDetailRepository
) {
    suspend fun invoke(productId: String): ProductDetail =
        productDetailRepository.getProductDetail(productId)
}