package com.mona15dev.data.product.list.api

import com.mona15dev.data.product.list.dto.ProductListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductNetwork {
    @GET("search")
    suspend fun getProductsByName(
        @Query("q") query: String
    ): ProductListDto
}