package com.dimchel.footballobserver.presentation.league

import com.arellomobile.mvp.MvpView
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionerModel


interface LeagueView : MvpView {

    fun updateTitleView(leagueName: String)
    fun updateMatchdayView(matchday: Int)

    fun showStandingList(competitionersList: List<CompetitionerModel>)
    fun hideStandingList()

}