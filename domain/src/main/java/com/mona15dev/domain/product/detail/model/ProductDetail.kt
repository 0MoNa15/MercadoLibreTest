package com.mona15dev.domain.product.detail.model

data class ProductDetail(
    val id: String,
    val price: Int,
    val title: String,
    val pictures: List<String>,
    val condition: ProductCondition
)