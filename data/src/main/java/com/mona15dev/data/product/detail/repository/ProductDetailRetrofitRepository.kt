package com.mona15dev.data.product.detail.repository

import com.mona15dev.data.product.api.ProductNetwork
import javax.inject.Inject

class ProductDetailRetrofitRepository @Inject constructor(
    private val network: ProductNetwork
) {

}