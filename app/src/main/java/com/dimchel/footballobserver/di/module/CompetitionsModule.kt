package com.dimchel.footballobserver.di.module

import com.dimchel.footballobserver.common.Logger
import com.dimchel.footballobserver.data.mappers.CompetitionMapper
import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepo
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepoImpl
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
    fun provideCompetitionRepo(apiProvider: ApiServiceProvider, mapper: CompetitionMapper): CompetitionRepo {
        return CompetitionRepoImpl(apiProvider, mapper)
    }

}