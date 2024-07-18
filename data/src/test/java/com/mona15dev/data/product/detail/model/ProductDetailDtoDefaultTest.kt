package com.mona15dev.data.product.detail.model

import com.mona15dev.domain.product.detail.model.ProductCondition

data class ProductDetailDtoDefaultTest(
    val id: String = "MLA1398196809",
    val price: Int = 62999,
    val title: String = "Escritorio Mesa De Trabajo Home Collection Melamina 1 Cajon Color Nevado/everest",
    val pictures: List<String> = listOf(
        "https://http2.mlstatic.com/D_643621-MLU72748586153_112023-O.jpg",
        "https://http2.mlstatic.com/D_802347-MLU72748461601_112023-O.jpg"
    ),
    val condition : String = ProductCondition.NEW.displayName
)