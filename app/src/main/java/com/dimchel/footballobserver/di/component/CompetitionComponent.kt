package com.dimchel.footballobserver.di.component

import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.scopes.CompetitionScope
import com.dimchel.footballobserver.presentation.competitions.CompetitionPresenter
import dagger.Subcomponent


@CompetitionScope
@Subcomponent(modules = arrayOf(CompetitionsModule::class))
interface CompetitionComponent {

    fun inject(competitionPresenter: CompetitionPresenter)

}