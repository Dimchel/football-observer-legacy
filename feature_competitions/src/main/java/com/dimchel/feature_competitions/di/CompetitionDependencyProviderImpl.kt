package com.dimchel.feature_competitions.di

import android.app.Application
import com.dimchel.core_architecture.di.BaseDependencyProvider

class CompetitionDependencyProviderImpl : BaseDependencyProvider<CompetitionDependencyProvider>() {

	override fun createDependency(application: Application): CompetitionDependencyProvider =
		DaggerCompetitionComponent.builder()
			.appContext(application)
			.build()
}
