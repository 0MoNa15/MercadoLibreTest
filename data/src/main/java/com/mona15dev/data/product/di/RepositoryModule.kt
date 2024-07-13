package com.mona15dev.data.product.di

import com.mona15dev.data.product.list.api.ProductNetwork
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

    @Singleton
    @Provides
    fun provideProductListRetrofitRepository(network: ProductNetwork)
        : ProductListRetrofitRepository
        = ProductListRetrofitRepository(network)

    //BD
    @Singleton
    @Provides
    fun provideProductListRoomRepository()
        : ProductListRoomRepository
        = ProductListRoomRepository()

    @Singleton
    @Provides
    fun provideRecipeRepository(remote: ProductListRetrofitRepository, local: ProductListRoomRepository)
        : ProductListRepository
        = ProductListRepositoryImpl(remote, local)
}