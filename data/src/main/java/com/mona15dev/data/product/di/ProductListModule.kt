package com.mona15dev.data.product.di

import com.mona15dev.data.product.list.repository.ProductListRepositoryImpl
import com.mona15dev.domain.product.list.repository.ProductListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductListModule {
    @Binds
    abstract fun bindRepository(productListRepository: ProductListRepositoryImpl): ProductListRepository
}