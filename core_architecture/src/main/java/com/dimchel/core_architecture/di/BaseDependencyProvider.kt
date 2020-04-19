package com.dimchel.core_architecture.di

import android.app.Application

abstract class BaseDependencyProvider<T> : DependencyProvider<T> {

	private var dependencies : T? = null

	abstract fun createDependency(application: Application): T

	override fun provide(application: Application): T {
		if (dependencies == null) {
			dependencies = createDependency(application)
		}

		return dependencies!!
	}

	override fun release() {
		dependencies = null
	}
}