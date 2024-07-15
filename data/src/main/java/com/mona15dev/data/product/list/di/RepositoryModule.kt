package com.mona15dev.data.product.list.di

import com.mona15dev.data.product.api.ProductNetwork
import com.mona15dev.data.product.list.database.dao.ProductDao
import com.mona15dev.data.product.list.repository.ProductListRepositoryImpl
import com.mona15dev.data.product.list.repository.ProductListRetrofitRepository
import com.mona15dev.data.product.list.repository.ProductListRoomRepository
import com.mona15dev.domain.product.list.repository.ProductListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductListRetrofitRepository(network: ProductNetwork): ProductListRetrofitRepository {
        return ProductListRetrofitRepository(network)
    }

    @Provides
    @Singleton
    fun provideProductListRoomRepository(dao: ProductDao): ProductListRoomRepository {
        return ProductListRoomRepository(dao)
    }

    @Provides
    @Singleton
    fun provideProductListRepository(
        remote: ProductListRetrofitRepository,
        local: ProductListRoomRepository
    ): ProductListRepository {
        return ProductListRepositoryImpl(remote, local)
    }
}