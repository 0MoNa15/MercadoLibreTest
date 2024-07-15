package com.mona15dev.data.product.list.repository

import com.mona15dev.data.product.api.ProductNetwork
import com.mona15dev.data.product.list.dto.ProductDto
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
                //Temporal crear clase personalizada de manejo de errores
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
    }
}

//Temporal pasar a un Mapper independiente
fun mapProductDtoToProduct(productDto: ProductDto): Product {
    return Product(
        id = productDto.id,
        title = productDto.title,
        price = productDto.price,
        thumbnail = productDto.thumbnail,
        free_shipping = productDto.free_shipping
    )
}