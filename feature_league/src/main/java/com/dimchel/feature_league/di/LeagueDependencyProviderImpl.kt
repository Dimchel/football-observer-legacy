package com.dimchel.feature_league.di

import android.app.Application
import com.dimchel.core_architecture.di.BaseDependencyProvider
import com.dimchel.feature_competitions_api.di.CompetitionApiDependencyProviderImpl

object LeagueDependencyProviderImpl : BaseDependencyProvider<LeagueDependencyProvider>() {

	override fun createDependency(application: Application): LeagueDependencyProvider =
		DaggerLeagueComponent.factory().create(
			application,
			CompetitionApiDependencyProviderImpl.provide(application),
		)
}
