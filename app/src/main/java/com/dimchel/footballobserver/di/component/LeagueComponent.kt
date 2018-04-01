package com.dimchel.footballobserver.di.component

import com.dimchel.footballobserver.di.module.LeagueModule
import com.dimchel.footballobserver.di.scopes.LeagueScope
import com.dimchel.footballobserver.presentation.league.LeagueActivity
import dagger.Subcomponent


@LeagueScope
@Subcomponent(modules = [(LeagueModule::class)])
interface LeagueComponent {

    fun inject(leagueActivity: LeagueActivity)

}