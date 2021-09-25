package com.dimchel.feature_competitions.di

import android.app.Application
import com.dimchel.core_architecture.di.BaseDependencyProvider
import com.dimchel.core_network.di.CoreNetworkDependencyProviderImpl

object CompetitionDependencyProviderImpl : BaseDependencyProvider<CompetitionDependencyProvider>() {

	override fun createDependency(application: Application): CompetitionDependencyProvider =
		DaggerCompetitionComponent.factory().create(
			application,
			CoreNetworkDependencyProviderImpl.provide(application),
		)
}
