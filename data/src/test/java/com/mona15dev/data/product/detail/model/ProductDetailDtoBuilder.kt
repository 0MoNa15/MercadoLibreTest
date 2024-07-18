package com.mona15dev.data.product.detail.model

import com.mona15dev.data.product.detail.dto.PictureDto
import com.mona15dev.data.product.detail.dto.ProductDetailDto
import com.mona15dev.domain.product.detail.model.ProductCondition

class ProductDetailDtoBuilder {
    private var id: String = ProductDetailDtoDefaultTest().id
    private var title: String = ProductDetailDtoDefaultTest().title
    private var price: Int = ProductDetailDtoDefaultTest().price
    private var condition: String = ProductCondition.NEW.displayName
    private var pictures: List<PictureDto> = emptyList()

    fun withId(id: String) = apply { this.id = id }
    fun withTitle(title: String) = apply { this.title = title }
    fun withPrice(price: Int) = apply { this.price = price }
    fun withCondition(condition: String) = apply { this.condition = condition }
    fun withPictures(pictures: List<PictureDto>) = apply { this.pictures = pictures }

    fun build() = ProductDetailDto(
        id = id,
        title = title,
        price = price,
        condition = condition,
        pictures = pictures
    )
}