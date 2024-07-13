package com.mona15dev.data.product.di

import com.mona15dev.domain.product.list.repository.ProductListRepository
import com.mona15dev.domain.product.list.usecase.GetProductByNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetProductsByName (productListRepository: ProductListRepository)
        : GetProductByNameUseCase
        //= GetProductByNameUseCase(productListRepository)
        = GetProductByNameUseCase()
}