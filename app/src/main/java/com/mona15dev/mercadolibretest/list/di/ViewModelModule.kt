package com.mona15dev.mercadolibretest.list.di

import com.mona15dev.domain.product.list.repository.ProductListRepository
import com.mona15dev.domain.product.list.usecase.GetProductByNameUseCase
import com.mona15dev.mercadolibretest.list.ProductListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideGetProductByNameUseCase(
        repository: ProductListRepository
    ): GetProductByNameUseCase {
        return GetProductByNameUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideProductListViewModel(
        getProductByNameUseCase: GetProductByNameUseCase
    ): ProductListViewModel {
        return ProductListViewModel(getProductByNameUseCase)
    }
}

