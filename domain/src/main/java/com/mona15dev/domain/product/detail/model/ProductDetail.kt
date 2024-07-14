package com.mona15dev.domain.product.detail.model

data class ProductDetail(
    val price: String,
    val title: String,
    val pictures: List<String>,
    val condition: ProductCondition
) {
    companion object {
        fun createProductDetail(
            price: String,
            title: String,
            pictures: List<String>,
            condition: String
        ): ProductDetail {
            val formattedCondition = ProductCondition.fromString(condition)
            return ProductDetail(
                price = price,
                title = title,
                pictures = pictures,
                condition = formattedCondition
            )
        }
    }
}

