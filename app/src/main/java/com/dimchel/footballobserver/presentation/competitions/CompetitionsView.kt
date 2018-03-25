package com.dimchel.footballobserver.presentation.competitions

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel


@StateStrategyType(AddToEndSingleStrategy::class)
interface CompetitionsView: MvpView{

    fun showCompetitionsListView(show: Boolean)

    @StateStrategyType(SkipStrategy::class)
    fun updateCompetitionsListView(competitionsList: List<CompetitionModel>)

    fun showLeagueView(competitionId: Long)

    fun showProgress(show: Boolean)

}