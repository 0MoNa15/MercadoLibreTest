package com.mona15dev.domain.product.detail

import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.repository.ProductDetailRepository
import com.mona15dev.domain.product.detail.usecase.GetProductDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class GetProductDetailUseCaseTest {

    @Mock
    private lateinit var productDetailRepository: ProductDetailRepository

    private lateinit var getProductDetailUseCase: GetProductDetailUseCase

    @Before
    fun setUp() {
        getProductDetailUseCase = GetProductDetailUseCase(productDetailRepository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `invoke debería devolver un detalle de producto válido`() = runBlocking {
        // Arrange
        val productId = "1"
        val expectedProductDetail = ProductDetailBuilder()
            .withId("1")
            .withPrice(1500)
            .withTitle("Escritorio blanco")
            .withPictures(listOf("https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg", "https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg"))
            .withCondition(ProductCondition.NEW)
            .build()

        `when`(productDetailRepository.getProductDetail(productId)).thenReturn(expectedProductDetail)

        // Act
        val result = getProductDetailUseCase.invoke(productId)

        // Assert
        verify(productDetailRepository).getProductDetail(productId)
        assertEquals(expectedProductDetail, result)
    }
}