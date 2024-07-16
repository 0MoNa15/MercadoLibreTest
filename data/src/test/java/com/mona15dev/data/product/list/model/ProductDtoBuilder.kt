package com.mona15dev.data.product.list.model

import com.mona15dev.data.product.list.dto.ProductDto

class ProductDtoBuilder {
    private var id: String = "MLA1398196809"
    private var title: String = "Escritorio Mesa De Trabajo Home Collection Melamina 1 Cajon Color Nevado/everest"
    private var price: Double = 56999.0
    private var thumbnail: String = "https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg"
    private var condition: String = "new"

    fun withId(id: String): ProductDtoBuilder = apply { this.id = id }

    fun withTitle(title: String): ProductDtoBuilder = apply { this.title = title }

    fun withPrice(price: Double): ProductDtoBuilder = apply { this.price = price }

    fun withThumbnail(thumbnail: String): ProductDtoBuilder = apply { this.thumbnail = thumbnail }

    fun withCondition(condition: String): ProductDtoBuilder = apply { this.condition = condition }

    fun build(): ProductDto = ProductDto(id, title, price, thumbnail, condition)
}