package com.dimchel.footballobserver.presentation.competitions

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel


@StateStrategyType(AddToEndSingleStrategy::class)
interface CompetitionsView: MvpView{

    @StateStrategyType(SkipStrategy::class)
    fun showCompetitionsList(competitionsList: List<CompetitionModel>)

    @StateStrategyType(SkipStrategy::class)
    fun showLeagueView(competitionId: Long)

}