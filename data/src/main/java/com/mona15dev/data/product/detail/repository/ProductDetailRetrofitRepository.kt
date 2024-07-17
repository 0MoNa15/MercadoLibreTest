package com.mona15dev.data.product.detail.repository

import com.mona15dev.data.product.api.ProductNetwork
import com.mona15dev.data.product.detail.anticorruption.ProductDetailTranslate
import com.mona15dev.domain.product.detail.model.ProductDetail
import com.mona15dev.domain.product.exceptions.DataException
import com.mona15dev.domain.product.exceptions.NetworkError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class ProductDetailRetrofitRepository @Inject constructor(
    private val network: ProductNetwork
) {
    suspend fun getProductDetail(productId: String) : ProductDetail {
        return withContext(Dispatchers.IO) {
            try {
                val response = network.apiProductDetail(productId)
                ProductDetailTranslate.mapProductDetailDtoToDomain(response)
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