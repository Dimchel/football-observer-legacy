package com.dimchel.feature_league.di

import android.content.Context
import dagger.*
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class LeagueScope

@LeagueScope
@Component(modules = [(LeagueModule::class)])
interface LeagueComponent : LeagueDependencyProvider {

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun appContext(appContext: Context): Builder

		fun build(): LeagueComponent
	}
}

@Module
abstract class LeagueModule