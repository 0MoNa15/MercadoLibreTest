package com.mona15dev.domain.product.detail.model

class ProductDetailBuilder {
    private var id: String = ProductDetailDefaultTest().id
    private var price: Int = ProductDetailDefaultTest().price
    private var title: String = ProductDetailDefaultTest().title
    private var pictures: List<String> = ProductDetailDefaultTest().pictures
    private var condition: ProductCondition = ProductDetailDefaultTest().condition

    fun build() = ProductDetail(
        id = id,
        price = price,
        title = title,
        pictures = pictures,
        condition = condition
    )
}