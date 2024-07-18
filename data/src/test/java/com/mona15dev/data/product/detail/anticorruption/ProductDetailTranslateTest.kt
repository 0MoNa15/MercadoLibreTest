package com.mona15dev.data.product.detail.anticorruption

import com.mona15dev.data.product.detail.model.PictureDtoBuilder
import com.mona15dev.data.product.detail.model.ProductDetailBuilder
import com.mona15dev.data.product.detail.model.ProductDetailDtoBuilder
import com.mona15dev.domain.product.detail.model.ProductCondition
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductDetailTranslateTest {

    @Test
    fun `mapProductDetailDtoToDomain debería devolver un detalle de producto válido`() {
        // Arrange
        val urlImage = "https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg"
        val pictureDto = PictureDtoBuilder()
            .withSecureUrl(urlImage)
            .build()
        val productDetailDto = ProductDetailDtoBuilder()
            .withCondition("new")
            .withPictures(listOf(pictureDto))
            .build()
        val expectedProductDetail = ProductDetailBuilder()
            .withCondition(ProductCondition.NEW)
            .withPictures(listOf(urlImage))
            .build()

        // Act
        val result = ProductDetailTranslate.mapProductDetailDtoToDomain(productDetailDto)

        // Assert
        assertEquals(expectedProductDetail, result)
    }
}