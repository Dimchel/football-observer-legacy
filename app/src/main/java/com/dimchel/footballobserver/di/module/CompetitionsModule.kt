package com.dimchel.footballobserver.di.module

import com.dimchel.footballobserver.data.mappers.CompetitionMapper
import com.dimchel.core_network.providers.ApiServiceProvider
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepository
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepositoryImpl
import com.dimchel.footballobserver.di.scopes.CompetitionScope
import dagger.Module
import dagger.Provides


@Module
class CompetitionsModule {

    @CompetitionScope
    @Provides
    fun provideCompetitionMapper(): CompetitionMapper {
        return CompetitionMapper()
    }

    @CompetitionScope
    @Provides
    fun provideCompetitionRepo(apiProvider: com.dimchel.core_network.providers.ApiServiceProvider, mapper: CompetitionMapper): CompetitionRepository {
        return CompetitionRepositoryImpl(apiProvider, mapper)
    }

}