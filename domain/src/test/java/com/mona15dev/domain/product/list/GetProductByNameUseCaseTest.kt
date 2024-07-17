package com.mona15dev.domain.product.list

import com.mona15dev.domain.product.list.repository.ProductListRepository
import com.mona15dev.domain.product.list.usecase.GetProductByNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
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
        getProductByNameUseCase = GetProductByNameUseCase(productListRepository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `invoke debería devolver una lista de productos válida`() = runBlocking {
        // Arrange
        val searchByName = "Laptop"
        val expectedProductList = listOf(
            ProductBuilder()
                .withId("1")
                .withTitle("Escritorio blanco")
                .withPrice(1500.0)
                .withThumbnail("https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg")
                .withCondition("new")
                .build(),
            ProductBuilder()
                .withId("2")
                .withTitle("Laptop HP")
                .withPrice(1000.0)
                .withThumbnail("https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg")
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
}