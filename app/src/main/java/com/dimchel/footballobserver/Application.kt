package com.dimchel.footballobserver

import android.app.Application
import com.dimchel.footballobserver.di.component.AppComponent
import com.dimchel.footballobserver.di.component.CompetitionComponent
import com.dimchel.footballobserver.di.component.DaggerAppComponent
import com.dimchel.footballobserver.di.module.AppModule
import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.module.NetworkModule


class Application : Application() {

    private val baseUrl = "http://api.football-data.org/v1/"

    companion object {
        lateinit var instance: com.dimchel.footballobserver.Application
    }

    private lateinit var appComponent: AppComponent
    private var competitionComponent: CompetitionComponent? = null

    override fun onCreate() {
        super.onCreate()

        instance = this

        appComponent = initAppComponent()
    }

    private fun initAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(baseUrl))
                .build()
    }

    public fun initCompetitionComponent(): CompetitionComponent {
        val component = appComponent.competitionComponent(CompetitionsModule())

        competitionComponent = component

        return component
    }

    public fun destroyCompetitionComponent() {
        competitionComponent = null
    }

}