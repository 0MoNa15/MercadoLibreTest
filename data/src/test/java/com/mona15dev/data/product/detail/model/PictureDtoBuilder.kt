package com.mona15dev.data.product.detail.model

import com.mona15dev.data.product.detail.dto.PictureDto

class PictureDtoBuilder {
    private var id: String = "default_id"
    private var secureUrl: String = "https://default.url/image.jpg"

    fun withId(id: String) = apply { this.id = id }
    fun withSecureUrl(secureUrl: String) = apply { this.secureUrl = secureUrl }

    fun build() = PictureDto(
        id = id,
        secureUrl = secureUrl
    )
}