package com.mona15dev.data.product.detail.repository

import com.mona15dev.data.product.api.ProductNetwork
import com.mona15dev.data.product.detail.dto.ProductDetailDto
import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.model.ProductDetail
import retrofit2.HttpException
import javax.inject.Inject

class ProductDetailRetrofitRepository @Inject constructor(
    private val network: ProductNetwork
) {
    suspend fun getProductDetail(productId: String) : ProductDetail {
        return try {
            val response = network.apiProductDetail(productId)
            mapProductDetailDtoToProductDetail(response)
        } catch (e: HttpException) {
            // Tempral crear clase personalizada de manejo de errores
            when (e.code()) {
                400 -> throw Exception("Bad Request")
                401 -> throw Exception("Unauthorized")
                404 -> throw Exception("Not Found")
                500 -> throw Exception("Server Error")
                else -> throw Exception("Unknown HTTP error")
            }
        } catch (e: Exception) {
            throw Exception("Network error: ${e.message}")
        }
    }

    // Temporal pasar a un Mapper independiente
    fun mapProductDetailDtoToProductDetail(productDetailDto: ProductDetailDto): ProductDetail {
        return ProductDetail(
            id = productDetailDto.id,
            title = productDetailDto.title,
            price = productDetailDto.price,
            condition = ProductCondition.fromString(productDetailDto.condition),
            pictures = productDetailDto.pictures.map { it.secureUrl }
        )
    }
}