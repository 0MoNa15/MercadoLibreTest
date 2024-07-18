package com.mona15dev.domain.product.list.model

class ProductBuilder {
    private var id: String = ProductDefaultTest().id
    private var title: String = ProductDefaultTest().title
    private var price: Double = ProductDefaultTest().price
    private var thumbnail: String = ProductDefaultTest().thumbnail
    private var condition: String = ProductDefaultTest().condition

    fun withId(id: String): ProductBuilder = apply { this.id = id }

    fun withTitle(title: String): ProductBuilder = apply { this.title = title }

    fun withPrice(price: Double): ProductBuilder = apply { this.price = price }

    fun withThumbnail(thumbnail: String): ProductBuilder = apply { this.thumbnail = thumbnail }

    fun withCondition(condition: String): ProductBuilder = apply { this.condition = condition }

    fun build(): Product = Product(id, title, price, thumbnail, condition)
}