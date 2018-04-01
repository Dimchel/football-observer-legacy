package com.dimchel.footballobserver.di.component

import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.module.LeagueModule
import com.dimchel.footballobserver.di.scopes.CompetitionScope
import com.dimchel.footballobserver.presentation.competitions.CompetitionsActivity
import dagger.Subcomponent


@CompetitionScope
@Subcomponent(modules = [(CompetitionsModule::class)])
interface CompetitionComponent {

    fun leagueComponent(LeagueModule: LeagueModule): LeagueComponent

    fun inject(competitionsActivity: CompetitionsActivity)

}