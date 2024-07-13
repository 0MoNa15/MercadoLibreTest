package com.mona15dev.data.product.list.dto

import com.google.gson.annotations.SerializedName

data class ProductListDto (
    @SerializedName("results")
    var listProducts: List<ProductDto>
)