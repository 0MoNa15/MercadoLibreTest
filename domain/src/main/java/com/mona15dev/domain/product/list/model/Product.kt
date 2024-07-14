package com.mona15dev.domain.product.list.model

data class Product(
    var id: String,
    var title: String,
    var price: Double,
    var thumbnail: String,
    var free_shipping: Boolean
)
