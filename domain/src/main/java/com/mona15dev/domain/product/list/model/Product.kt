package com.mona15dev.domain.product.list.model

data class Product(
    var id: String,
    var title: String,
    var price: Double,
    var thumbnail: String,
    var condition: String
)

fun Product.getShortTitle(maxLength: Int = 15): String {
    return if (title.length > maxLength) {
        title.take(maxLength)
    } else {
        title
    }
}