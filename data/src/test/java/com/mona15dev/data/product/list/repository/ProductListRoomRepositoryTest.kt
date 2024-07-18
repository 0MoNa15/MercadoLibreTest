package com.mona15dev.data.product.list.repository

import com.mona15dev.data.product.list.database.dao.ProductDao
import com.mona15dev.data.product.list.database.entity.mapperToModel
import com.mona15dev.data.product.list.model.ProductEntityBuilder
import kotlinx.coroutines.Dispatchers
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

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.Assert.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class ProductListRoomRepositoryTest {

    @Mock
    private lateinit var productDao: ProductDao

    private lateinit var productListRoomRepository: ProductListRoomRepository

    @Before
    fun setUp() {
        productListRoomRepository = ProductListRoomRepository(productDao)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getProductsByName should return valid product list`() = runTest {
        // Arrange
        val search = "Biblioteca"
        val expectedProductList = listOf(
            ProductEntityBuilder().build(),
            ProductEntityBuilder()
                .withId("MLA1412185121")
                .withTitle("Biblioteca Repisa Estantes Color Olmo/blanco Home Collection")
                .withPrice(89999.0)
                .withThumbnail("http://http2.mlstatic.com/D_925857-MLU75981802107_042024-I.jpg")
                .withCondition("new")
                .build()
        )
        `when`(productDao.getProductListByName(search)).thenReturn(expectedProductList)

        // Act
        val result = productListRoomRepository.getProductsByName(search)

        // Assert
        verify(productDao).getProductListByName(search)
        assertEquals(expectedProductList.map { it.mapperToModel() }, result)
    }

    @Test
    fun `getProductsByName should return empty list when no products are found`() = runTest {
        // Arrange
        val search = "NonExistingProduct"
        `when`(productDao.getProductListByName(search)).thenReturn(emptyList())

        // Act
        val result = productListRoomRepository.getProductsByName(search)

        // Assert
        verify(productDao).getProductListByName(search)
        assertTrue(result.isEmpty())
    }
}