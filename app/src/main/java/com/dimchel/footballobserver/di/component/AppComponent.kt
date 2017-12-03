package com.dimchel.footballobserver.di.component

import com.dimchel.footballobserver.di.module.AppModule
import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {

    fun competitionComponent(competitionsModule: CompetitionsModule): CompetitionComponent

}