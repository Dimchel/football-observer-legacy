package com.dimchel.footballobserver.di.component

import com.dimchel.footballobserver.MainActivity
import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.scopes.CompetitionScope
import dagger.Subcomponent


@CompetitionScope
@Subcomponent(modules = arrayOf(CompetitionsModule::class))
interface CompetitionComponent {

    fun inject(mainActivity: MainActivity)

}