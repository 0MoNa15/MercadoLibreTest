package com.mona15dev.data.product.detail.model

import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.model.ProductDetail

class ProductDetailBuilder {

    private var id: String = ProductDetailDefaultTest().id
    private var price: Int = ProductDetailDefaultTest().price
    private var title: String = ProductDetailDefaultTest().title
    private var pictures: List<String> = ProductDetailDefaultTest().pictures
    private var condition: ProductCondition = ProductCondition.NEW

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