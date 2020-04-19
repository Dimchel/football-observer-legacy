package com.dimchel.feature_competitions.di

import android.content.Context
import com.dimchel.feature_competitions.data.repositories.CompetitionRepository
import com.dimchel.feature_competitions.data.repositories.CompetitionRepositoryImpl
import dagger.*
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CompetitionScope

@CompetitionScope
@Component(modules = [(CompetitionsModule::class)])
interface CompetitionComponent : CompetitionDependencyProvider {

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun appContext(appContext: Context): Builder

		fun build(): CompetitionComponent
	}
}

@Module
abstract class CompetitionsModule {

	@CompetitionScope
	@Binds
	abstract fun provideCompetitionRepository(competitionRepository: CompetitionRepositoryImpl): CompetitionRepository

}