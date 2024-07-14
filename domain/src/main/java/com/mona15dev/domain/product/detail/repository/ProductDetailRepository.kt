package com.mona15dev.domain.product.detail.repository

import com.mona15dev.domain.product.detail.model.ProductDetail

interface ProductDetailRepository {
    suspend fun getProductDetail(productId: String): ProductDetail
}