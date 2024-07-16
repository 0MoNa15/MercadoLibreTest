package com.mona15dev.data.product.detail.model

import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.model.ProductDetail

class ProductDetailBuilder {
    private var id: String = "default_id"
    private var title: String = "default_title"
    private var price: Int = 0
    private var condition: ProductCondition = ProductCondition.NEW
    private var pictures: List<String> = emptyList()

    fun withId(id: String) = apply { this.id = id }
    fun withTitle(title: String) = apply { this.title = title }
    fun withPrice(price: Int) = apply { this.price = price }
    fun withCondition(condition: ProductCondition) = apply { this.condition = condition }
    fun withPictures(pictures: List<String>) = apply { this.pictures = pictures }

    fun build() = ProductDetail(
        id = id,
        title = title,
        price = price,
        condition = condition,
        pictures = pictures
    )
}