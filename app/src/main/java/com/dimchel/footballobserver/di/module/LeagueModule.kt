package com.dimchel.footballobserver.di.module

import com.dimchel.footballobserver.data.repos.competition.CompetitionRepo
import com.dimchel.footballobserver.di.scopes.LeagueScope
import com.dimchel.footballobserver.presentation.league.LeaguePresenter
import dagger.Module
import dagger.Provides


@Module
class LeagueModule(private val leagueId: Long) {

    @LeagueScope
    @Provides
    fun provideLeaguePresenter(competitionRepo: CompetitionRepo): LeaguePresenter {
        return LeaguePresenter(leagueId, competitionRepo)
    }

}