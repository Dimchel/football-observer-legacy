package com.dimchel.feature_league.di

import android.content.Context
import com.dimchel.feature_competitions_api.di.CompetitionApiDependencyProvider
import com.dimchel.feature_league.presentation.LeagueFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class LeagueScope

@LeagueScope
@Component(
	dependencies = [CompetitionApiDependencyProvider::class],
)
interface LeagueComponent : LeagueDependencyProvider {

	@Component.Factory
	interface Factory {
		fun create(
			@BindsInstance appContext: Context,
			competitionApiDependencyProvider: CompetitionApiDependencyProvider,
		): LeagueComponent
	}

	fun inject(fragment: LeagueFragment)

}