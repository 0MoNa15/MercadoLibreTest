package com.mona15dev.domain.product.detail.model

data class ProductDetail(
    val id: String,
    val price: Int,
    val title: String,
    val pictures: List<String>,
    val condition: ProductCondition
) {
    companion object {
        fun createProductDetail(
            id: String,
            price: Int,
            title: String,
            pictures: List<String>,
            condition: String
        ): ProductDetail {
            val formattedCondition = ProductCondition.fromString(condition)
            return ProductDetail(
                id = id,
                price = price,
                title = title,
                pictures = pictures,
                condition = formattedCondition
            )
        }
    }
}

