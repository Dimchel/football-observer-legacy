package com.dimchel.footballobserver

import android.app.Application
import com.dimchel.footballobserver.di.component.AppComponent
import com.dimchel.footballobserver.di.component.CompetitionComponent
import com.dimchel.footballobserver.di.component.DaggerAppComponent
import com.dimchel.footballobserver.di.module.AppModule
import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.module.NetworkModule


class Application : Application() {

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

    // ===========================================================
    // di
    // ===========================================================

    private fun initAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(AppConstants.BASE_API_URL))
                .build()
    }

    fun initCompetitionComponent(): CompetitionComponent {
        val component = appComponent.competitionComponent(CompetitionsModule())

        competitionComponent = component

        return component
    }

    fun destroyCompetitionComponent() {
        competitionComponent = null
    }

}