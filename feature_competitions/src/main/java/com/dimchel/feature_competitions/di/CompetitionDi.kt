package com.dimchel.feature_competitions.di

import android.content.Context
import com.dimchel.feature_competitions.presentation.CompetitionsFragment
import com.dimchel.feature_competitions_api.di.CompetitionApiDependencyProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CompetitionScope

@CompetitionScope
@Component(
	dependencies = [CompetitionApiDependencyProvider::class],
)
interface CompetitionComponent : CompetitionDependencyProvider {

	@Component.Factory
	interface Factory {
		fun create(
			@BindsInstance appContext: Context,
			competitionApiDependencyProvider: CompetitionApiDependencyProvider,
		): CompetitionComponent
	}

	fun inject(competitionsFragment: CompetitionsFragment)
}