package com.mona15dev.domain.product.detail

import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.model.ProductDetail

class ProductDetailBuilder {
    private var id: String = "default_id"
    private var price: Int = 0
    private var title: String = "default_title"
    private var pictures: List<String> = listOf()
    private var condition: ProductCondition = ProductCondition.NEW

    fun withId(id: String) = apply { this.id = id }
    fun withPrice(price: Int) = apply { this.price = price }
    fun withTitle(title: String) = apply { this.title = title }
    fun withPictures(pictures: List<String>) = apply { this.pictures = pictures }
    fun withCondition(condition: ProductCondition) = apply { this.condition = condition }

    fun build() = ProductDetail(
        id = id,
        price = price,
        title = title,
        pictures = pictures,
        condition = condition
    )
}