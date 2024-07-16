package com.mona15dev.data.product.list.model

import com.mona15dev.domain.product.list.model.Product

class ProductBuilder {
    private var id: String = "MLA1398196809"
    private var title: String = "Escritorio Mesa De Trabajo Home Collection Melamina 1 Cajon Color Nevado/everest"
    private var price: Double = 56999.0
    private var thumbnail: String = "https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg"
    private var condition: String = "new"

    fun withId(id: String): ProductBuilder = apply { this.id = id }

    fun withTitle(title: String): ProductBuilder = apply { this.title = title }

    fun withPrice(price: Double): ProductBuilder = apply { this.price = price }

    fun withThumbnail(thumbnail: String): ProductBuilder = apply { this.thumbnail = thumbnail }

    fun withCondition(condition: String): ProductBuilder = apply { this.condition = condition }

    fun build(): Product = Product(id, title, price, thumbnail, condition)
}