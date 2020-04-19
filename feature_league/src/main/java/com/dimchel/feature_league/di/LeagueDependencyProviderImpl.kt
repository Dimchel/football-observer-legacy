package com.dimchel.feature_league.di

import android.app.Application
import com.dimchel.core_architecture.di.BaseDependencyProvider

class LeagueDependencyProviderImpl : BaseDependencyProvider<LeagueDependencyProvider>() {

	override fun createDependency(application: Application): LeagueDependencyProvider =
		DaggerLeagueComponent.builder()
			.appContext(application)
			.build()
}
