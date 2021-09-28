package com.dimchel.feature_competitions_api.di

import android.content.Context
import com.dimchel.core_network.di.CoreNetworkDependencyProvider
import com.dimchel.feature_competitions_api.data.repositories.CompetitionRepository
import com.dimchel.feature_competitions_api.data.repositories.CompetitionRepositoryImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CompetitionApiScope

@CompetitionApiScope
@Component(
	dependencies = [CoreNetworkDependencyProvider::class],
	modules = [(CompetitionsModule::class)]
)
interface CompetitionApiComponent : CompetitionApiDependencyProvider {

	@Component.Factory
	interface Factory {
		fun create(
			@BindsInstance appContext: Context,
			coreNetworkDependencyProvider: CoreNetworkDependencyProvider,
		): CompetitionApiComponent
	}
}

@Module
abstract class CompetitionsModule {

	@CompetitionApiScope
	@Binds
	abstract fun provideCompetitionRepository(competitionRepository: CompetitionRepositoryImpl): CompetitionRepository

}