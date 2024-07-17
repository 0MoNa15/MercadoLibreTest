package com.mona15dev.data.product.list.repository

import com.mona15dev.data.product.list.database.dao.ProductDao
import com.mona15dev.data.product.list.database.entity.mapperToModel
import com.mona15dev.data.product.list.model.ProductEntityBuilder
import kotlinx.coroutines.Dispatchers
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

@RunWith(MockitoJUnitRunner::class)
class ProductListRoomRepositoryTest {

    @Mock
    private lateinit var productDao: ProductDao

    private lateinit var productListRoomRepository: ProductListRoomRepository

    @Before
    fun setUp() {
        productListRoomRepository = ProductListRoomRepository(productDao)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getProductsByName debería devolver una lista de productos válida`() = runBlocking {
        // Arrange
        val search = "Laptop"
        val entityList = listOf(
            ProductEntityBuilder()
                .withId("1")
                .withTitle("Escritorio ajustable")
                .withPrice(1500.0)
                .withThumbnail("https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg")
                .withCondition("new")
                .build(),
            ProductEntityBuilder()
                .withId("2")
                .withTitle("Laptop HP")
                .withPrice(1000.0)
                .withThumbnail("https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg")
                .withCondition("new")
                .build()
        )
        `when`(productDao.getProductListByName(search)).thenReturn(entityList)

        // Act
        val result = productListRoomRepository.getProductsByName(search)

        // Assert
        verify(productDao).getProductListByName(search)
        assertEquals(entityList.map { it.mapperToModel() }, result)
    }
}