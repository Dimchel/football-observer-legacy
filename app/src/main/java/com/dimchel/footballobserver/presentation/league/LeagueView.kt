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

    fun showStandingListView(show: Boolean)

    @StateStrategyType(SkipStrategy::class)
    fun updateStandingListView(competitionersList: List<CompetitionerModel>)

    fun showProgressView(show: Boolean)

}