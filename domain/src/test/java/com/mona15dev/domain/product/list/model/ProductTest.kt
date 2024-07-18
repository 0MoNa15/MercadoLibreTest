package com.mona15dev.domain.product.list.model

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductTest {

    @Test
    fun `getShortTitle debería devolver el título completo cuando su longitud es menor que la predeterminada maxLength`() {
        // Arrange
        val expectedProductTitle = "Mesa"
        val product = ProductBuilder()
            .withTitle(expectedProductTitle)
            .build()

        // Action
        val result = product.getShortTitle()

        // Assert
        assertEquals(expectedProductTitle, result)
    }

    @Test
    fun `getShortTitle debería devolver el título cortado cuando su longitud es mayor que la predeterminada maxLength`() {
        // Arrange
        val expectedProductTitle = "Escritorio Mesa..."
        val validateTitle = ProductDefaultTest().title
        val product = ProductBuilder()
            .withTitle(validateTitle)
            .build()

        // Action
        val result = product.getShortTitle()

        // Assert
        assertEquals(expectedProductTitle, result)
    }

    @Test
    fun `secureThumbnail debería devolver la URL 'https' cuando la url de la imágen comienza con http`() {
        // Arrange
        val expectedUrlImage = ProductDefaultTest().thumbnail
        val product = ProductBuilder()
            .withThumbnail("http://http2.mlstatic.com/D_643621-MLU72748586153_112023-O.jpg")
            .build()

        // Action
        val result = product.secureThumbnail

        // Assert
        assertEquals(expectedUrlImage, result)
    }

    @Test
    fun `secureThumbnail debería devolver la url de la imágen tal como está cuando comienza con https`() {
        // Arrange
        val expectedUrlImage = ProductDefaultTest().thumbnail
        val product = ProductBuilder().build()

        // Action
        val result = product.secureThumbnail

        // Assert
        assertEquals(expectedUrlImage, result)
    }
}