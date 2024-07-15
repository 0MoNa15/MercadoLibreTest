package com.mona15dev.data.product.detail.repository

import com.mona15dev.domain.product.detail.model.ProductDetail
import com.mona15dev.domain.product.detail.repository.ProductDetailRepository
import javax.inject.Inject

class ProductDetailRepositoryImpl @Inject constructor(
    private val remote: ProductDetailRetrofitRepository
) : ProductDetailRepository {

    override suspend fun getProductDetail(productId: String): ProductDetail {
        return remote.getProductDetail(productId)
    }
}