package com.mona15dev.data.product.di

import com.google.gson.GsonBuilder
import com.mona15dev.data.product.list.api.ProductNetwork
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
class HttpClientModule {

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
    fun provideProductNetwork(retrofit: Retrofit): ProductNetwork
        = retrofit.create(ProductNetwork::class.java)
}