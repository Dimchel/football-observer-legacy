package com.dimchel.footballobserver.di.component

import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.scopes.CompetitionScope
import com.dimchel.footballobserver.presentation.competitions.CompetitionPresenter
import com.dimchel.footballobserver.presentation.league.LeaguePresenter
import dagger.Subcomponent


@CompetitionScope
@Subcomponent(modules = [(CompetitionsModule::class)])
interface CompetitionComponent {

    fun inject(competitionPresenter: CompetitionPresenter)
    fun inject(leaguePresenter: LeaguePresenter)

}