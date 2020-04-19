package com.dimchel.core_network.di

import android.content.Context
import com.dimchel.core_network.providers.ApiServiceProvider
import com.dimchel.core_network.providers.ApiServiceProviderImpl
import com.dimchel.core_network.providers.FootballApiService
import dagger.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CoreNetworkScope

@CoreNetworkScope
@Component(modules = [NetworkModule::class])
interface CoreNetworkComponent : CoreNetworkDependencyProvider {

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun appContext(appContext: Context): Builder

		fun build(): CoreNetworkComponent
	}
}

@Module
abstract class NetworkModule(private val baseUrl: String) {

	@CoreNetworkScope
	@Provides
	fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
		level = HttpLoggingInterceptor.Level.BODY
	}

	@CoreNetworkScope
	@Provides
	fun provideOkHttpInterceptor(): Interceptor =
		Interceptor { chain ->
			val request = chain.request().newBuilder()
				.addHeader("X-Auth-Token", "850f87bfd30f4c50866402773c7ed417")
				.build()

			chain.proceed(request)
		}

	@CoreNetworkScope
	@Provides
	fun provideOkHttpClient(headerInterceptor: Interceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
		OkHttpClient.Builder()
			.addInterceptor(headerInterceptor)
			.addInterceptor(loggingInterceptor)
			.build()

	@CoreNetworkScope
	@Provides
	fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

	@CoreNetworkScope
	@Provides
	fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit =
		Retrofit.Builder()
			.client(okHttpClient)
			.addConverterFactory(gsonConverterFactory)
			.baseUrl(baseUrl)
			.build()

	@CoreNetworkScope
	@Provides
	fun provideFootballApiService(retrofit: Retrofit): FootballApiService =
		retrofit.create(FootballApiService::class.java)

	@CoreNetworkScope
	@Binds
	abstract fun provideApiServiceProvider(apiService: ApiServiceProviderImpl): ApiServiceProvider

}
