package com.mona15dev.domain.product.list.usecase

import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.domain.product.list.model.ProductBuilder
import com.mona15dev.domain.product.list.repository.ProductListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class GetProductByNameUseCaseTest {

    @Mock
    private lateinit var productListRepository: ProductListRepository

    private lateinit var getProductByNameUseCase: GetProductByNameUseCase

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        getProductByNameUseCase = GetProductByNameUseCase(productListRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `invoke debería devolver una lista de productos válida`() = runBlocking {
        // Arrange
        val searchByName = "Biblioteca"
        val expectedProductList = listOf(
            ProductBuilder().build(),
            ProductBuilder()
                .withId("MLA1412185121")
                .withTitle("Biblioteca Repisa Estantes Color Olmo/blanco Home Collection")
                .withPrice(89999.0)
                .withThumbnail("http://http2.mlstatic.com/D_925857-MLU75981802107_042024-I.jpg")
                .withCondition("new")
                .build()
        )
        `when`(productListRepository.getProductsByName(searchByName)).thenReturn(expectedProductList)

        // Act
        val result = getProductByNameUseCase.invoke(searchByName)

        // Assert
        verify(productListRepository).getProductsByName(searchByName)
        assertEquals(expectedProductList, result)
    }

    @Test
    fun `invoke debería devolver una lista vacía cuando no se encuentren productos`() = runBlocking {
        // Arrange
        val searchByName = "notExistingProduct"
        val expectedProductList = emptyList<Product>()
        `when`(productListRepository.getProductsByName(searchByName)).thenReturn(expectedProductList)

        // Act
        val result = getProductByNameUseCase.invoke(searchByName)

        // Assert
        verify(productListRepository).getProductsByName(searchByName)
        assertEquals(expectedProductList, result)
    }
}