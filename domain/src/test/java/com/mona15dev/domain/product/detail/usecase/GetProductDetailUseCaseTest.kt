package com.mona15dev.domain.product.detail.usecase

import com.mona15dev.domain.product.detail.model.ProductDetailBuilder
import com.mona15dev.domain.product.detail.model.ProductDetailDefaultTest
import com.mona15dev.domain.product.detail.repository.ProductDetailRepository
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
        val productId = ProductDetailDefaultTest().id
        val expectedProductDetail = ProductDetailBuilder().build()
        `when`(productDetailRepository.getProductDetail(productId)).thenReturn(expectedProductDetail)

        // Act
        val result = getProductDetailUseCase.invoke(productId)

        // Assert
        verify(productDetailRepository).getProductDetail(productId)
        assertEquals(expectedProductDetail, result)
    }

    @Test
    fun `invoke debería devolver un detalle de producto nulo`() = runBlocking {
        val productId = "null"
        `when`(productDetailRepository.getProductDetail(productId)).thenReturn(null)

        // Act
        val result = getProductDetailUseCase.invoke(productId)

        // Assert
        verify(productDetailRepository).getProductDetail(productId)
        assertEquals(null, result)
    }

    @Test
    fun `invoke debería devolver un detalle de producto vacío`() = runBlocking {
        // Arrange
        val productId = "empty"
        val expectedProductDetail = ProductDetailBuilder().build()
        `when`(productDetailRepository.getProductDetail(productId)).thenReturn(expectedProductDetail)

        // Act
        val result = getProductDetailUseCase.invoke(productId)

        // Assert
        verify(productDetailRepository).getProductDetail(productId)
        assertEquals(expectedProductDetail, result)
    }
}