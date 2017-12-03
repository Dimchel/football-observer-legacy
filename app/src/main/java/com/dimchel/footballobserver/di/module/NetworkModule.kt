package com.dimchel.footballobserver.di.module

import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import com.dimchel.footballobserver.data.networks.ApiServiceProviderImpl
import com.dimchel.footballobserver.data.networks.api.FootballApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                    .addConverterFactory(gsonConverterFactory)
                    .baseUrl(baseUrl)
                    .build()
    }

    @Provides
    @Singleton
    fun provideFootballApiService(retrofit: Retrofit): FootballApiService {
        return retrofit.create(FootballApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideFootballApiServiceProvider(apiService: FootballApiService): ApiServiceProvider {
        return ApiServiceProviderImpl(apiService)
    }

}
