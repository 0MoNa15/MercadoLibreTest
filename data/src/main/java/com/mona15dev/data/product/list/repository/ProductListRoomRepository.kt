package com.mona15dev.data.product.list.repository

import com.mona15dev.data.product.list.database.dao.ProductDao
import com.mona15dev.data.product.list.database.entity.ProductEntity
import com.mona15dev.data.product.list.database.entity.mapperToEntity
import com.mona15dev.data.product.list.database.entity.mapperToModel
import com.mona15dev.domain.product.exceptions.DataException
import com.mona15dev.domain.product.list.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

const val ERROR_BD = "Error en la base de datos"

class ProductListRoomRepository @Inject constructor(
    private val productDao: ProductDao
) {
    suspend fun getProductsByName(search: String): List<Product> {
        return withContext(Dispatchers.IO) {
            try {
                productDao.getProductListByName(search).map {
                    it.mapperToModel()
                }
            } catch (e: IOException) {
                throw DataException.DatabaseException(ERROR_BD)
            }
        }
    }

    suspend fun insertUpcomingProductList(remoteProductList: List<Product>) {
        return withContext(Dispatchers.IO) {
            val entitiesProductList = remoteProductList.map {
                it.mapperToEntity()
            }
            productDao.insertUpcomingProductList(entitiesProductList)
        }
    }

    suspend fun insertProduct(product: ProductEntity) {
        return withContext(Dispatchers.IO) {
            productDao.insertProduct(product)
        }
    }
}