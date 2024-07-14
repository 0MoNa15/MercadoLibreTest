package com.mona15dev.data.product.api

import com.mona15dev.data.product.detail.dto.ProductDetailDto
import com.mona15dev.data.product.list.dto.ProductListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductNetwork {
    @GET("sites/MLA/search")
    suspend fun apiSearchProducts(
        @Query("q") query: String
    ): ProductListDto

    @GET("items/{id}")
    suspend fun apiProductDetail(
        @Path("id") productId: String
    ): ProductDetailDto
}