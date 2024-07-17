package com.mona15dev.data.product.detail.anticorruption

import com.mona15dev.data.product.detail.dto.ProductDetailDto
import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.model.ProductDetail

class ProductDetailTranslate {
    companion object {
        fun mapProductDetailDtoToDomain(productDetailDto: ProductDetailDto): ProductDetail {
            return ProductDetail(
                id = productDetailDto.id,
                title = productDetailDto.title,
                price = productDetailDto.price,
                condition = ProductCondition.fromString(productDetailDto.condition),
                pictures = productDetailDto.pictures.map { it.secureUrl }
            )
        }
    }
}