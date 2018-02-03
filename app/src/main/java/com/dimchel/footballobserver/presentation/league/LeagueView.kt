package com.dimchel.footballobserver.presentation.league

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionerModel


@StateStrategyType(AddToEndSingleStrategy::class)
interface LeagueView : MvpView {

    fun updateTitleView(leagueName: String)
    fun updateMatchdayView(matchday: Int)

    @StateStrategyType(SkipStrategy::class)
    fun showStandingList(competitionersList: List<CompetitionerModel>)
    fun hideStandingList()

}