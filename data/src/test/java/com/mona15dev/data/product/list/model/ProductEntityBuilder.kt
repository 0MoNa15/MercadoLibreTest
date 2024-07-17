package com.mona15dev.data.product.list.model

import com.mona15dev.data.product.list.database.entity.ProductEntity

class ProductEntityBuilder {
    private var id: String = "default_id"
    private var title: String = "default_title"
    private var price: Double = 0.0
    private var thumbnail: String = "default_thumbnail"
    private var condition: String = "default_condition"

    fun withId(id: String) = apply { this.id = id }
    fun withTitle(title: String) = apply { this.title = title }
    fun withPrice(price: Double) = apply { this.price = price }
    fun withThumbnail(thumbnail: String) = apply { this.thumbnail = thumbnail }
    fun withCondition(condition: String) = apply { this.condition = condition }

    fun build() = ProductEntity(
        id = id,
        title = title,
        price = price,
        thumbnail = thumbnail,
        condition = condition
    )
}