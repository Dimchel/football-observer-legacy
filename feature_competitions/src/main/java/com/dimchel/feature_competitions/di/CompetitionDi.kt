package com.dimchel.feature_competitions.di

import android.content.Context
import com.dimchel.core_network.di.CoreNetworkDependencyProvider
import com.dimchel.feature_competitions.data.repositories.CompetitionRepository
import com.dimchel.feature_competitions.data.repositories.CompetitionRepositoryImpl
import com.dimchel.feature_competitions.presentation.CompetitionsActivity
import dagger.*
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CompetitionScope

@CompetitionScope
@Component(
	dependencies = [CoreNetworkDependencyProvider::class],
	modules = [(CompetitionsModule::class)]
)
interface CompetitionComponent : CompetitionDependencyProvider {

	@Component.Factory
	interface Factory {
		fun create(
			@BindsInstance appContext: Context,
			coreNetworkDependencyProvider: CoreNetworkDependencyProvider,
		): CompetitionComponent
	}

	fun inject(competitionsActivity: CompetitionsActivity)
}

@Module
abstract class CompetitionsModule {

	@CompetitionScope
	@Binds
	abstract fun provideCompetitionRepository(competitionRepository: CompetitionRepositoryImpl): CompetitionRepository

}