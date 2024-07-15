package com.mona15dev.data.product.list.repository

import com.mona15dev.data.product.api.ProductNetwork
import com.mona15dev.data.product.list.dto.ProductDto
import com.mona15dev.domain.product.exceptions.DataException
import com.mona15dev.domain.product.exceptions.NetworkError
import com.mona15dev.domain.product.list.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class ProductListRetrofitRepository @Inject constructor(
    private val network: ProductNetwork
) {

    suspend fun getProductsByNameRetrofit(query: String) : List<Product> {
        return withContext(Dispatchers.IO) {
            try {
                val response = network.apiSearchProducts(query)
                response.listProducts.map { mapProductDtoToProduct(it) }
            } catch (e: HttpException) {
                val errorCode = e.code()
                val networkError = NetworkError.entries.find { it.code == errorCode }
                throw DataException.NetworkException(
                    networkError?.message ?: NetworkError.UNKNOWN_ERROR.message
                )
            } catch (e: Exception) {
                throw DataException.NetworkException(NetworkError.UNKNOWN_ERROR.message)
            }
        }
    }
}

//Temporal pasar a un Mapper independiente
fun mapProductDtoToProduct(productDto: ProductDto): Product {
    return Product(
        id = productDto.id,
        title = productDto.title,
        price = productDto.price,
        thumbnail = productDto.thumbnail,
        condition = productDto.condition
    )
}