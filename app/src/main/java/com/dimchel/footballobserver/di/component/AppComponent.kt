package com.dimchel.footballobserver.di.component

import com.dimchel.footballobserver.di.module.AppModule
import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.core_network.di.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(AppModule::class), (com.dimchel.core_network.di.NetworkModule::class)])
interface AppComponent {

    fun competitionComponent(competitionsModule: CompetitionsModule): CompetitionComponent
//    fun clubComponent(clubModule: ClubModule): ClubComponent

}