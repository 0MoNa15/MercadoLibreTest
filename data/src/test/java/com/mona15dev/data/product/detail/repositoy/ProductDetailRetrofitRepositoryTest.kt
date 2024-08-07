package com.mona15dev.data.product.detail.repositoy


import com.mona15dev.data.product.api.ProductNetwork
import com.mona15dev.data.product.detail.model.PictureDtoBuilder
import com.mona15dev.data.product.detail.model.ProductDetailDtoBuilder
import com.mona15dev.data.product.detail.repository.ProductDetailRetrofitRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

@RunWith(MockitoJUnitRunner::class)
class ProductDetailRetrofitRepositoryTest {

    @Mock
    private lateinit var productNetwork: ProductNetwork

    private lateinit var productDetailRetrofitRepository: ProductDetailRetrofitRepository

    @Before
    fun setUp() {
        productDetailRetrofitRepository = ProductDetailRetrofitRepository(productNetwork)
    }

    @Test
    fun `getProductDetail() exitoso, debería devolver un detalle de producto válido`() = runBlocking {
        // Arrange
        val pictureDtoBuilder = PictureDtoBuilder().withSecureUrl("https://http2.mlstatic.com/D_643621-MLU72748586153_112023-I.jpg").build()
        val productDetailDto = ProductDetailDtoBuilder()
            .withId("MLA123456789")
            .withTitle("Laptop")
            .withPrice(1500)
            .withCondition("new")
            .withPictures(listOf(pictureDtoBuilder))
            .build()

        val productId = "MLA123456789"
        val expectedProductDetail = productDetailRetrofitRepository.mapProductDetailDtoToProductDetail(productDetailDto)

        `when`(productNetwork.apiProductDetail(productId)).thenReturn(productDetailDto)

        // Act
        val result = productDetailRetrofitRepository.getProductDetail(productId)

        // Assert
        verify(productNetwork).apiProductDetail(productId)
        assertEquals(expectedProductDetail, result)
    }
}