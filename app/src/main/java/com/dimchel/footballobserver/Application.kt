package com.dimchel.footballobserver

import android.app.Application
import com.dimchel.footballobserver.di.component.AppComponent
import com.dimchel.footballobserver.di.component.ClubComponent
import com.dimchel.footballobserver.di.component.CompetitionComponent
import com.dimchel.footballobserver.di.component.DaggerAppComponent
import com.dimchel.footballobserver.di.module.AppModule
import com.dimchel.footballobserver.di.module.ClubModule
import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.module.NetworkModule


class Application : Application() {

    companion object {
        lateinit var instance: com.dimchel.footballobserver.Application
    }

    private lateinit var appComponent: AppComponent

    private var competitionComponent: CompetitionComponent? = null
    private var clubComponent: ClubComponent? = null

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
        if (competitionComponent == null) {
            val component = appComponent.competitionComponent(CompetitionsModule())

            competitionComponent = component
        }

        return competitionComponent as CompetitionComponent
    }

    fun destroyCompetitionComponent() {
        competitionComponent = null
    }

    fun initClubComponent(): ClubComponent {
        if (clubComponent == null) {
            val component = appComponent.clubComponent(ClubModule())

            clubComponent = component
        }

        return clubComponent as ClubComponent
    }

    fun destroyClubComponent() {
        clubComponent = null
    }

}