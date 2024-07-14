package com.mona15dev.data.product.detail.di

import com.mona15dev.data.product.api.ProductNetwork
import com.mona15dev.data.product.detail.repository.ProductDetailRepositoryImpl
import com.mona15dev.data.product.detail.repository.ProductDetailRetrofitRepository
import com.mona15dev.domain.product.detail.repository.ProductDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DetailRepositoryModule {
    @Provides
    @Singleton
    fun provideProductDetailRetrofitRepository(network: ProductNetwork): ProductDetailRetrofitRepository {
        return ProductDetailRetrofitRepository(network)
    }

    @Provides
    @Singleton
    fun provideProductDetailRepository(
        remote: ProductDetailRetrofitRepository
    ): ProductDetailRepository {
        return ProductDetailRepositoryImpl(remote)
    }
}