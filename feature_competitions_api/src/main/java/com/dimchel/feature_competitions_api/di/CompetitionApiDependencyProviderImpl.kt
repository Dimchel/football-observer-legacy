package com.dimchel.feature_competitions_api.di

import android.app.Application
import com.dimchel.core_architecture.di.BaseDependencyProvider
import com.dimchel.core_network.di.CoreNetworkDependencyProviderImpl

object CompetitionApiDependencyProviderImpl : BaseDependencyProvider<CompetitionApiDependencyProvider>() {

	override fun createDependency(application: Application): CompetitionApiDependencyProvider =
		DaggerCompetitionApiComponent.factory().create(
			application,
			CoreNetworkDependencyProviderImpl.provide(application),
		)
}
