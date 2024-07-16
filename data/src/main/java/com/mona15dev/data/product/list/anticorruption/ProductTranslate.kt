package com.mona15dev.data.product.list.anticorruption

import com.mona15dev.data.product.list.dto.ProductDto
import com.mona15dev.domain.product.list.model.Product

class ProductTranslate {
    companion object {
        fun mapProductDtoToDomain(productDto: ProductDto): Product {
            return Product(
                id = productDto.id,
                title = productDto.title,
                price = productDto.price,
                thumbnail = productDto.thumbnail,
                condition = productDto.condition
            )
        }

        fun mapProductsDtoToDomain(productListDto: List<ProductDto>): List<Product> {
            return productListDto.map { mapProductDtoToDomain(it) }
        }
    }
}