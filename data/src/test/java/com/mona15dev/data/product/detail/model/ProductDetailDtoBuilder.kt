package com.mona15dev.data.product.detail.model

import com.mona15dev.data.product.detail.dto.PictureDto
import com.mona15dev.data.product.detail.dto.ProductDetailDto

class ProductDetailDtoBuilder {
    private var id: String = "default_id"
    private var title: String = "default_title"
    private var price: Int = 0
    private var condition: String = "new"
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