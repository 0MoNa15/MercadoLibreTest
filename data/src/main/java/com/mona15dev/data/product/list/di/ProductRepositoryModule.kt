package com.mona15dev.data.product.list.di

import com.google.gson.GsonBuilder
import com.mona15dev.data.product.list.api.ProductNetwork
import com.mona15dev.data.product.list.repository.ProductListRepositoryImpl
import com.mona15dev.data.product.list.repository.ProductListRetrofitRepository
import com.mona15dev.data.product.list.repository.ProductListRoomRepository
import com.mona15dev.domain.product.list.repository.ProductListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://api.mercadolibre.com/sites/MLA/"
//https://api.mercadolibre.com/sites/MLA/search?q=Motorola

@Module
@InstallIn(SingletonComponent::class)
object ProductRepositoryModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val builder = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideProductNetwork(retrofit: Retrofit): ProductNetwork {
        return retrofit.create(ProductNetwork::class.java)
    }

    @Singleton
    @Provides
    fun provideProductListRetrofitRepository(network: ProductNetwork): ProductListRetrofitRepository {
        return ProductListRetrofitRepository(network)
    }

    //BD
    @Provides
    @Singleton
    fun provideProductListRoomRepository(): ProductListRoomRepository {
        return ProductListRoomRepository()
    }

    @Singleton
    @Provides
    fun provideProductListRepository(
        remote: ProductListRetrofitRepository,
        local: ProductListRoomRepository
    ): ProductListRepository {
        return ProductListRepositoryImpl(remote, local)
    }
}