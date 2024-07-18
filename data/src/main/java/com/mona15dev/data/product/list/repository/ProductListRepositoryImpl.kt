package com.mona15dev.data.product.list.repository

import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.domain.product.list.repository.ProductListRepository
import javax.inject.Inject

class ProductListRepositoryImpl @Inject constructor(
    private val remote: ProductListRetrofitRepository,
    private val local: ProductListRoomRepository
) : ProductListRepository {

    override suspend fun getProductsByName(search: String): List<Product> {
        var productListByName = local.getProductsByName(search)

        if(productListByName.isEmpty()){
            productListByName = remote.getProductsByNameRetrofit(search)
            local.insertUpcomingProductList(productListByName)
        }

        return productListByName
    }
}