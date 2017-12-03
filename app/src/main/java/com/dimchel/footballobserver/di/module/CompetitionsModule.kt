package com.dimchel.footballobserver.di.module

import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import com.dimchel.footballobserver.data.repos.competitions.CompetitionsRepo
import com.dimchel.footballobserver.data.repos.competitions.CompetitionsRepoImpl
import com.dimchel.footballobserver.di.scopes.CompetitionScope
import dagger.Module
import dagger.Provides


@Module
class CompetitionsModule {

    @CompetitionScope
    @Provides
    fun provideCompetitionRepo(apiProvider: ApiServiceProvider): CompetitionsRepo {
        return CompetitionsRepoImpl(apiProvider)
    }

}