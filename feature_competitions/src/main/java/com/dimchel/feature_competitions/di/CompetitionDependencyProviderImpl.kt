package com.dimchel.feature_competitions.di

import android.app.Application
import com.dimchel.core_architecture.di.BaseDependencyProvider
import com.dimchel.feature_competitions_api.di.CompetitionApiDependencyProviderImpl

object CompetitionDependencyProviderImpl : BaseDependencyProvider<CompetitionDependencyProvider>() {

	override fun createDependency(application: Application): CompetitionDependencyProvider =
		DaggerCompetitionComponent.factory().create(
			application,
			CompetitionApiDependencyProviderImpl.provide(application),
		)
}
