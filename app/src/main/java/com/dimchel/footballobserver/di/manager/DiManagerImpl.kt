package com.dimchel.footballobserver.di.manager

import com.dimchel.footballobserver.di.component.AppComponent
import com.dimchel.footballobserver.di.component.CompetitionComponent
import com.dimchel.footballobserver.di.component.LeagueComponent
import com.dimchel.footballobserver.di.module.CompetitionsModule
import com.dimchel.footballobserver.di.module.LeagueModule


class DiManagerImpl(private val appComponent: AppComponent): DiManager {

    private val TAG_COMPETITION_COMPONENT = "DiManagerImpl.TAG_COMPETITION_COMPONENT"
    private val TAG_LEAGUE_COMPONENT = "DiManagerImpl.TAG_LEAGUE_COMPONENT"

    private val listenersMap: HashMap<String, HashSet<String>> = HashMap()

    private var competitionComponent: CompetitionComponent? = null
    private var leagueComponent: LeagueComponent? = null

    override fun getCompetitionComponent(tag: String): CompetitionComponent {
        if (competitionComponent == null) {
            competitionComponent = appComponent.competitionComponent(CompetitionsModule())

            listenersMap[TAG_COMPETITION_COMPONENT] = hashSetOf(tag)
        } else{
            listenersMap[TAG_COMPETITION_COMPONENT]!!.add(tag)
        }

        return competitionComponent as CompetitionComponent
    }

    override fun releaseCompetitionComponent(tag: String) {
        listenersMap[TAG_COMPETITION_COMPONENT]!!.remove(tag)

        if (listenersMap[TAG_COMPETITION_COMPONENT]!!.isEmpty()) {
            competitionComponent = null
        }
    }

    override fun getLeagueComponent(tag: String, leagueId: Long): LeagueComponent {
        if (leagueComponent == null) {
            leagueComponent = competitionComponent!!.leagueComponent(LeagueModule(leagueId))

            listenersMap[TAG_LEAGUE_COMPONENT] = hashSetOf(tag)
        } else{
            listenersMap[TAG_LEAGUE_COMPONENT]!!.add(tag)
        }

        return leagueComponent as LeagueComponent
    }

    override fun releaseLeagueComponent(tag: String) {
        listenersMap[TAG_LEAGUE_COMPONENT]!!.remove(tag)

        if (listenersMap[TAG_LEAGUE_COMPONENT]!!.isEmpty()) {
            leagueComponent = null
        }
    }


}