package com.mona15dev.data.product.list.repository

import com.mona15dev.data.product.api.ProductNetwork
import com.mona15dev.data.product.list.anticorruption.ProductTranslate
import com.mona15dev.data.product.list.dto.ProductListDto
import com.mona15dev.data.product.list.model.ProductDtoBuilder
import com.mona15dev.domain.product.exceptions.DataException
import com.mona15dev.domain.product.exceptions.NetworkError
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class ProductListRetrofitRepositoryTest {

    @Mock
    private lateinit var productNetwork: ProductNetwork

    private lateinit var productListRetrofitRepository: ProductListRetrofitRepository

    @Before
    fun setUp() {
        productListRetrofitRepository = ProductListRetrofitRepository(productNetwork)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getProductsByNameRetrofit debería devolver una lista de producos válida`() = runBlocking {
        // Arrange
        val productDtoList = listOf(
            ProductDtoBuilder().build(),
            ProductDtoBuilder()
                .withId("MLA1398196808")
                .withTitle("escritorio melamina")
                .withPrice(2.0)
                .withThumbnail("https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg")
                .withCondition("usado")
                .build()
        )
        val searchQuery = "escritorio"
        val responseProductsDto = ProductListDto(productDtoList)
        `when`(productNetwork.apiSearchProducts(searchQuery)).thenReturn(responseProductsDto)
        val expectedDomainList = ProductTranslate.mapProductsDtoToDomain(productDtoList)

        // Act
        val result = productListRetrofitRepository.getProductsByNameRetrofit(searchQuery)

        // Assert
        verify(productNetwork).apiSearchProducts(searchQuery)
        assertEquals(expectedDomainList, result)
    }

    @Test
    fun `getProductsByNameRetrofit debería devolver una lista de productos vacía`() = runBlocking {
        // Arrange
        val searchQuery = "productoInexistente"
        val responseProductsDto = ProductListDto(emptyList())
        `when`(productNetwork.apiSearchProducts(searchQuery)).thenReturn(responseProductsDto)

        // Act
        val result = productListRetrofitRepository.getProductsByNameRetrofit(searchQuery)

        // Assert
        verify(productNetwork).apiSearchProducts(searchQuery)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `getProductsByNameRetrofit debería devolver la excepcion throw NoDataRecipeException`() = runBlocking {
        // Arrange
        val searchQuery = "er00r"
        val expected = DataException.NetworkException(NetworkError.UNKNOWN_ERROR.message)
        `when`(productNetwork.apiSearchProducts(searchQuery))
            .thenAnswer { throw DataException.NetworkException(NetworkError.UNKNOWN_ERROR.message) }

        // Act & Assert
        val exceptionResult = assertThrows(DataException.NetworkException::class.java) {
            runBlocking {
                productListRetrofitRepository.getProductsByNameRetrofit(searchQuery)
            }
        }
        assertEquals(expected.message, exceptionResult.message)
    }
}