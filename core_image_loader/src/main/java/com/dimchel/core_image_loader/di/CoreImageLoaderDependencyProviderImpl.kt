package com.dimchel.core_image_loader.di

import android.app.Application
import com.dimchel.core_architecture.di.BaseDependencyProvider
import com.dimchel.core_image_loader.image_loader.ImageLoaderProvider
import com.dimchel.core_image_loader.image_loader.ImageLoaderProviderImpl

object CoreImageLoaderDependencyProviderImpl : BaseDependencyProvider<CoreImageLoaderDependencyProvider>() {

	override fun createDependency(application: Application): CoreImageLoaderDependencyProvider =
		object : CoreImageLoaderDependencyProvider {
			override fun getImageLoaderProvider(): ImageLoaderProvider = ImageLoaderProviderImpl(application)
		}
}
