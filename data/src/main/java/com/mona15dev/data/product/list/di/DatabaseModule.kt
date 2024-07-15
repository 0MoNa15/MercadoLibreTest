package com.mona15dev.data.product.list.di
import android.content.Context
import androidx.room.Room
import com.mona15dev.data.product.list.database.AppDatabase
import com.mona15dev.data.product.list.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val NAME_DATABASE = "product_database"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            NAME_DATABASE)
            .build()
    }

    @Singleton
    @Provides
    fun provideUpcomingProductList(database: AppDatabase) : ProductDao {
        return database.upcomingProductListDao()
    }
}