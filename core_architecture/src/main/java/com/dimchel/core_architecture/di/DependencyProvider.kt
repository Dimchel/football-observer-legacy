package com.dimchel.core_architecture.di

import android.app.Application

interface DependencyProvider<T> {

	fun provide(application: Application): T
	fun release()

}