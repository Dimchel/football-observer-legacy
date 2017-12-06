package com.dimchel.footballobserver.di.module

import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import com.dimchel.footballobserver.data.networks.ApiServiceProviderImpl
import com.dimchel.footballobserver.data.networks.api.FootballApiService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                    .addHeader("X-Auth-Token", "850f87bfd30f4c50866402773c7ed417")
                    .build()

            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(headerInterceptor: Interceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRxCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJava2CallAdapterFactory)
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
