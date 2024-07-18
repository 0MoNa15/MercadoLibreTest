package com.mona15dev.domain.product.list.model

import com.mona15dev.domain.product.detail.model.ProductCondition

data class ProductDefaultTest(
    val id: String = "MLA1398196809",
    val title: String = "Escritorio Mesa De Trabajo Home Collection Melamina 1 Cajon Color Nevado/everest",
    val price: Double = 62999.0,
    val thumbnail: String = "https://http2.mlstatic.com/D_643621-MLU72748586153_112023-O.jpg",
    val condition: String = ProductCondition.NEW.displayName
)
