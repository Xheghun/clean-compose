package com.xheghun.composecleanarchitecture.di

import com.xheghun.composecleanarchitecture.common.Constants
import com.xheghun.composecleanarchitecture.data.remote.CoinAPI
import com.xheghun.composecleanarchitecture.data.repo.CoinRepoImpl
import com.xheghun.composecleanarchitecture.domain.repo.CoinRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(api: CoinAPI): CoinRepo {
        return CoinRepoImpl(api)
    }
}