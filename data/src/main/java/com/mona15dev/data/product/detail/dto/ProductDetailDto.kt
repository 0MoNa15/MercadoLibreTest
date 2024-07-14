package com.mona15dev.data.product.detail.dto

data class ProductDetailDto(
    val id: String,
    val title: String,
    val price: Int,
    val condition: String,
    val pictures: List<PictureDto>
)