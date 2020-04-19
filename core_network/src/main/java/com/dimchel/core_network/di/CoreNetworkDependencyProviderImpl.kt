package com.dimchel.core_network.di

import android.app.Application
import com.dimchel.core_architecture.di.BaseDependencyProvider

class CoreNetworkDependencyProviderImpl : BaseDependencyProvider<CoreNetworkDependencyProvider>() {

	override fun createDependency(application: Application): CoreNetworkDependencyProvider =
		DaggerCoreNetworkComponent.builder()
			.appContext(application)
			.build()
}